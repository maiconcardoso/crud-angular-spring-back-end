package com.maicon.crud_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maicon.crud_spring.enums.Category;
import com.maicon.crud_spring.enums.Status;
import com.maicon.crud_spring.enums.converters.CategoryConverter;
import com.maicon.crud_spring.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE course SET status = 'inativo' WHERE id = ?")
@Where(clause = "status = 'ativo'")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 60)
    @Column(length = 60, nullable = false)
    private String name;

    @NotNull
    @Column(length = 20, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;


}

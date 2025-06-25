package com.devsuperior.dscommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "O campo deve conter de 3 a 80 caracteres.")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 10, message = "O campo deve conter no minimo 10 caracteres")
    private String description;
    @Positive(message = "Inserir apenas valores positivos")
    private Double price;
    private String imgUrl;

}

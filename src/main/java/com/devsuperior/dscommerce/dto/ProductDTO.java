package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @NotNull(message = "Campo requerido")
    @Positive(message = "Inserir apenas valores positivos")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve conter pelo menos 1 categoria.")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        for (Category category : entity.getCategories()) {
            categories.add(new CategoryDTO(category));
        }
    }
}

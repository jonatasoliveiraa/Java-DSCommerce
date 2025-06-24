package com.devsuperior.dscommerce.mapper;


import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductConverter {

    ProductConverter CONVERTER = Mappers.getMapper(ProductConverter.class);

    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toListDTOS(List<Product> products);

    List<Product> toListEntities(List<ProductDTO> productDTOS);
}

package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.mapper.ProductConverter;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exception.DatabaseException;
import com.devsuperior.dscommerce.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(String name, Pageable pageable) {
        Page<Product> productPage = repository.searchByName(name, pageable);
        return productPage.map(ProductConverter.CONVERTER::toDTO);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
        return ProductConverter.CONVERTER.toDTO(entity);
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product entity = ProductConverter.CONVERTER.toEntity(productDTO);
        return ProductConverter.CONVERTER.toDTO(repository.save(entity));
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            return updateData(entity, dto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private ProductDTO updateData(Product entity, ProductDTO dto) {
        entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
        entity.setDescription(dto.getDescription() != null ? dto.getDescription() : entity.getDescription());
        entity.setPrice(dto.getPrice() != null ? dto.getPrice() : entity.getPrice());
        entity.setImgUrl(dto.getImgUrl() != null ? dto.getImgUrl() : entity.getImgUrl());
        return ProductConverter.CONVERTER.toDTO(entity);
    }
}

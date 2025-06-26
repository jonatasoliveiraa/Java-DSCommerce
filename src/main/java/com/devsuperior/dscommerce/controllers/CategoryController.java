package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.CategoryDTO;
import com.devsuperior.dscommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(service.findById(id));
//    }
//
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
//    @PostMapping
//    public ResponseEntity<CategoryDTO> insert(@Validated @RequestBody CategoryDTO dto) {
//        dto = service.insert(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);
//    }
}

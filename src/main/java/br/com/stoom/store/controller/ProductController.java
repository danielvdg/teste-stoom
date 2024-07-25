package br.com.stoom.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.stoom.store.model.dto.ProductDTO;
import br.com.stoom.store.model.entity.Product;

public interface ProductController {

    @GetMapping
    public ResponseEntity<List<Product>> findAll();

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO);

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id);
}

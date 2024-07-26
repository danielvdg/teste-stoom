package br.com.stoom.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.stoom.store.model.dto.ProductDTO;

public interface ProductController {

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll();

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO);

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id);

    @GetMapping("/brand/{id}")
    public ResponseEntity <List<ProductDTO>> findProductByBrandId(Long id);

    @GetMapping("/category/{id}")
    public  ResponseEntity<List<ProductDTO>> findProductByCategoryId(@PathVariable Long id);
}

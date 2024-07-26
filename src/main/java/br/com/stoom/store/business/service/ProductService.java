package br.com.stoom.store.business.service;

import java.util.List;
import java.util.Optional;

import br.com.stoom.store.model.entity.Product;


public interface ProductService {
    
    public Optional<Product> findById(Long id);     
    
    public List<Product> findAll();

    public Product create(Product product);

    public Product update(Long id, Product productDetails);

    public void delete(Long id);

    public Optional<Product> findProductByBrandId(Long id);

    public Optional<Product> findProductByCategoryId(Long id);
}

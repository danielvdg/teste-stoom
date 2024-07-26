package br.com.stoom.store.business.service;

import java.util.List;
import java.util.Optional;

import br.com.stoom.store.model.entity.Product;

public interface ProductService {
    
    public Optional<Product> findById(Long id);     
    
    public List<Product> findAll();

    public Product create(Product productDTO);

    public Product update(Long id, Product product);

    public void delete(Long id);

    public List<Product> findListProductByBrandId(Long id);

    public List<Product> findListProductByCategoryId(Long id);

    public void productActivator (Long id);
}

package br.com.stoom.store.business.service.implementation;

import br.com.stoom.store.business.service.ProductService;
import br.com.stoom.store.model.entity.Product;
import br.com.stoom.store.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
       if (product.getId() != null) {
           throw new RuntimeException("Product already exist.");   
        }        
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product update(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());

        return productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        product.setActive(false);
        productRepository.save(product);        
    }


}

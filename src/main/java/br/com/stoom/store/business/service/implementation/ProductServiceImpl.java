package br.com.stoom.store.business.service.implementation;

import br.com.stoom.store.business.service.ProductService;
import br.com.stoom.store.model.entity.Product;
import br.com.stoom.store.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    
    private final ProductRepository productRepository;

    

    public Product create(Product product) {        
        if(product.getId() != null) {
            throw new RuntimeException("Product already exist.");   
        }
        product.setActive(true);
        productRepository.save(product);
        
        return product;
    }

    public Optional<Product> findById(Long id) {
        return  productRepository.findById(id);
    }

   public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product update(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    
        product.setName(productDetails.getName());
        product.setBrands(productDetails.getBrands());
    
        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        product.setActive(false);
        productRepository.save(product);        
    }

    public List<Product> findListProductByBrandId(Long id) {
        return productRepository.findListProductByBrandId(id);       
    }

    public List<Product> findListProductByCategoryId(Long id) { 
        return productRepository.findListProductByCategoryId(id);
    }


}

package br.com.stoom.store.business.service.implementation;

import br.com.stoom.store.business.service.ProductService;
import br.com.stoom.store.business.service.mapper.ProductMapperService;
import br.com.stoom.store.model.dto.ProductDTO;
import br.com.stoom.store.model.entity.Product;
import br.com.stoom.store.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    
    private final ProductRepository productRepository;

    private final ProductMapperService productMapperService;

    public ProductDTO create(ProductDTO productDTO) {
        Product product =productMapperService.converterToEntity(productDTO);

        if(product.getId() != null) {
            throw new RuntimeException("Product already exist.");   
        }
        product.setActive(true);
        productRepository.save(product);

        productDTO = productMapperService.converterToDTO(product);
        
        return productDTO;
    }

    public Optional<ProductDTO> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductDTO productDTO = productMapperService.converterToDTO(product.get());
            return Optional.of(productDTO);
        } else {
            return Optional.empty();
        }

    }

   public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                       .map(productMapperService::converterToDTO)
                       .collect(Collectors.toList());
    }

    public ProductDTO update(Long id, ProductDTO productDetailsDTO) {
        Product productDetails = productMapperService.converterToEntity(productDetailsDTO);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    
        product.setName(productDetails.getName());
        product.setBrands(productDetails.getBrands());
    
        Product updatedProduct = productRepository.save(product);
        return productMapperService.converterToDTO(updatedProduct);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        product.setActive(false);
        productRepository.save(product);        
    }

    public List<ProductDTO> findProductByBrandId(Long id) {
        List<Product> products = productRepository.findProductByBrandId(id);
        
        return products.stream()
                .map(productMapperService::converterToDTO)
                .collect(Collectors.toList());
       
    }

    public List<ProductDTO> findProductByCategoryId(Long id) {
        List<Product> products = productRepository.findProductByCategoryId(id);
    
        return products.stream()
                .map(productMapperService::converterToDTO)
                .collect(Collectors.toList());
    }


}

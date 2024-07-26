package br.com.stoom.store.controller.implementation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.stoom.store.business.service.ProductService;
import br.com.stoom.store.business.service.mapper.ProductMapperService;
import br.com.stoom.store.controller.ProductController;
import br.com.stoom.store.model.dto.ProductDTO;
import br.com.stoom.store.model.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapperService productMapperService;

    public ResponseEntity<List<Product>> findAll() {
        List<Product> listProducts = productService.findAll();
        if(!listProducts.isEmpty())
            return new ResponseEntity<>(listProducts, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        
        Product product = productMapperService.converterToEntity(productDTO);

        product = productService.create(product);
        
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(product.getId())
            .toUri();
        
        return ResponseEntity.created(uri).body(product);
    }

    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product productDetails = productMapperService.converterToEntity(productDTO);
        Product updateproduct = productService.update(id, productDetails);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateproduct);
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Product> findProductByBrandId(@PathVariable Long id){
        return productService.findProductByBrandId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
         
    }

    public ResponseEntity<Product> findProductByCategoryId(@PathVariable Long id){
        return productService.findProductByCategoryId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
         
    }
    
}

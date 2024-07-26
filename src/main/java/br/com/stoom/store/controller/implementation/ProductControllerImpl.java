package br.com.stoom.store.controller.implementation;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.stoom.store.business.service.ProductService;
import br.com.stoom.store.controller.ProductController;
import br.com.stoom.store.model.dto.ProductDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductControllerImpl implements ProductController {
   
    private final ProductService productService;   

    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> listProducts = productService.findAll();
        if(!listProducts.isEmpty())
            return new ResponseEntity<>(listProducts, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
        
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(productDTO.getId())
            .toUri();
        
        return ResponseEntity.created(uri).body(productDTO);
    }

    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        
        ProductDTO updateproductDTO = productService.update(id, productDTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateproductDTO);
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<ProductDTO>> findProductByBrandId(@PathVariable Long id){
        List<ProductDTO> products=   productService.findProductByBrandId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(products);
         
    }
    public ResponseEntity<List<ProductDTO>> findProductByCategoryId(@PathVariable Long id) {
        List<ProductDTO> products = productService.findProductByCategoryId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(products);
    }
}

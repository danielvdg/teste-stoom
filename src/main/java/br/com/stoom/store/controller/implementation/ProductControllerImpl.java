package br.com.stoom.store.controller.implementation;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductControllerImpl implements ProductController {
   
    private final ProductService productService;   

    private final ProductMapperService productMapperService;

    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> listProducts = productService.findAll();
        
        if(!listProducts.isEmpty()) {
            List<ProductDTO> listProductDTOs = listProducts.stream()
                    .map(productMapperService::converterToDTO)
                    .collect(Collectors.toList());
        
            return new ResponseEntity<>(listProductDTOs, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            ProductDTO productDTO = productMapperService.converterToDTO(productOptional.get());
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        Product product =productMapperService.converterToEntity(productDTO);
        
        productService.create(product);
        
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(productDTO.getId())
            .toUri();

        productDTO = productMapperService.converterToDTO(product);
        
        return ResponseEntity.created(uri).body(productDTO);
    }

    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = productMapperService.converterToEntity(productDTO);
        
        Product updateproduct = productService.update(id, product);

        ProductDTO updateproductDTO = productMapperService.converterToDTO(updateproduct);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateproductDTO);
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<ProductDTO>> findProductByBrandId(@PathVariable Long id){
        List<Product> products = productService.findListProductByBrandId(id);
        if (!products.isEmpty()) {
            List<ProductDTO> productDTOs = products.stream()
                    .map(productMapperService::converterToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(productDTOs);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<List<ProductDTO>> findProductByCategoryId(@PathVariable Long id) {
        List<Product> products = productService.findListProductByCategoryId(id);
        if (!products.isEmpty()) {
            List<ProductDTO> productDTOs = products.stream()
                    .map(productMapperService::converterToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(productDTOs);
        } else {
            return ResponseEntity.noContent().build();
        }
        
    }
    
    public ResponseEntity<Void> productActivator(@PathVariable Long id) {
        productService.productActivator(id);
        return ResponseEntity.noContent().build();
    }

}

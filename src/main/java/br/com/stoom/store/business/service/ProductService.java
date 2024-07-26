package br.com.stoom.store.business.service;

import java.util.List;
import java.util.Optional;

import br.com.stoom.store.model.dto.ProductDTO;

public interface ProductService {
    
    public Optional<ProductDTO> findById(Long id);     
    
    public List<ProductDTO> findAll();

    public ProductDTO create(ProductDTO productDTO);

    public ProductDTO update(Long id, ProductDTO productDTO);

    public void delete(Long id);

    public List<ProductDTO> findProductByBrandId(Long id);

    public List<ProductDTO> findProductByCategoryId(Long id);
}

package br.com.stoom.store.business.service.mapper;

import br.com.stoom.store.model.dto.ProductDTO;
import br.com.stoom.store.model.entity.Product;

public interface ProductMapperService {

    public ProductDTO converterToDTO( Product product);

    public Product converterToEntity(ProductDTO productDTO);
    
}

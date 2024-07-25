package br.com.stoom.store.business.service.mapper.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.stoom.store.business.service.mapper.ProductMapperService;
import br.com.stoom.store.model.dto.ProductDTO;
import br.com.stoom.store.model.entity.Product;

@Service
public class ProductMapperImpl implements ProductMapperService {
    
    private ModelMapper modelMapper = new ModelMapper();

    public ProductDTO converterToDTO( Product product) {
        
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product converterToEntity(ProductDTO productDTO) {
        
        return modelMapper.map(productDTO, Product.class);
    }
}

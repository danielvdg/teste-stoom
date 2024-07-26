package br.com.stoom.store.model.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDTO {
    
    private Long id;
    private String name;
    private Set<ProductDTO> products;
}

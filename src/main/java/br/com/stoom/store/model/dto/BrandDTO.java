package br.com.stoom.store.model.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDTO {
    
    private Long id;
    private String name;
    @JsonIgnore
    private List<ProductDTO> products;
}

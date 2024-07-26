package br.com.stoom.store.model.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.stoom.store.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private String name;
    private String categoryKind;
    @JsonIgnore
    private List<Product> products;
    
}

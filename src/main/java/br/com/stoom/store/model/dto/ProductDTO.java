package br.com.stoom.store.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
  
    private Long id;
    private String name;
    private boolean active;
}
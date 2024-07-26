package br.com.stoom.store.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
  
    private Long id;
    private String name;
    private boolean active;
    private List<BrandDTO> brands;
    private List<CategoryDTO> categories;
    private List<PriceDTO> prices;

}
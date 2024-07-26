package br.com.stoom.store.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.stoom.store.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDTO {

    private Long id;
    private String priceKind;
    private Long amount;
    private Long lot;
    private LocalDateTime madeIn;
    private LocalDateTime expirationDate;
    @JsonIgnore
    private List<Product> products;
    
}

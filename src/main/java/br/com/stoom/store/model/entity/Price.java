package br.com.stoom.store.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String priceKind;

    @Column
    private Long amount;

    @Column
    private Long lot;

    @Column
    private LocalDateTime madeIn;

    @Column
    private LocalDateTime expirationDate;

    @ManyToMany(mappedBy = "prices")
    @JsonIgnore
    private List<Product> products;
    
}

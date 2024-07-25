package br.com.stoom.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.stoom.store.model.entity.Price;

public interface PriceRepository extends JpaRepository<Price,Long> {
    
}

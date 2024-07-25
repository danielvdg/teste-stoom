package br.com.stoom.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.stoom.store.model.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    
}

package br.com.stoom.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.stoom.store.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
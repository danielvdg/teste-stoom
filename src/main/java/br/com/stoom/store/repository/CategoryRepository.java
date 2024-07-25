package br.com.stoom.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.stoom.store.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}

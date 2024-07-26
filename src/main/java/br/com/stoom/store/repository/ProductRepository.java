package br.com.stoom.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.stoom.store.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.*, b.name  FROM Product p " + 
    "INNER JOIN product_brand pb ON p.id = pb.product_id " +
    "INNER JOIN  BRAND b ON b.id = pb.brand_id  WHERE pb.brand_id = :brandId", nativeQuery = true)
    public Optional<Product> findProductByBrandId(@Param("brandId") Long brandId);

    @Query(value = "SELECT p.*, c.name  FROM Product p " + 
    "INNER JOIN product_category pt ON p.id = pt.product_id " +
    "INNER JOIN  CATEGORY c ON c.id = pt.category_id  WHERE pt.category_id = :categoryId  LIMIT 10", nativeQuery = true)
    public Optional<Product> findProductByCategoryId(@Param("categoryId") Long categoryId);
}
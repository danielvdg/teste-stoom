package br.com.stoom.store.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.stoom.store.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.*, b.name  FROM Product p " + 
    "INNER JOIN product_brand pb ON p.id = pb.product_id " +
    "INNER JOIN  BRAND b ON b.id = pb.brand_id  WHERE pb.brand_id = :brandId", nativeQuery = true)
    public List<Product> findProductByBrandId(@Param("brandId") Long brandId);

    @Query(value = "SELECT p.*, c.name  FROM Product p " + 
    "INNER JOIN product_category pc ON p.id = pc.product_id " +
    "INNER JOIN CATEGORY c ON c.id = pc.category_id  WHERE pc.category_id = :categoryId ", nativeQuery = true)
    public List<Product> findProductByCategoryId(@Param("categoryId") Long categoryId);
}
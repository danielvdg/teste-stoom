package br.com.stoom.store.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.stoom.store.model.entity.Brand;
import br.com.stoom.store.model.entity.Category;
import br.com.stoom.store.model.entity.Product;
import br.com.stoom.store.repository.BrandRepository;
import br.com.stoom.store.repository.CategoryRepository;
import br.com.stoom.store.repository.ProductRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(
        ProductRepository productRepository,
        BrandRepository brandRepository,
        CategoryRepository categoryRepository) {
        return args -> {
            // Criar marcas
            Brand brand1 = new Brand();
            brand1.setName("Tio Jõao");
            brandRepository.save(brand1);

            Brand brand2 = new Brand();
            brand2.setName("Carioca");
            brandRepository.save(brand2);

            Brand brand3 = new Brand();
            brand3.setName("batatão");
            brandRepository.save(brand3);

            //Criar Categorias
            Category category1 = new Category();
            category1.setName("Comida");
            category1.setCategoryKind("fit");
            categoryRepository.save(category1);

            Category category2 = new Category();
            category2.setName("Eletronicos");
            category2.setCategoryKind("smartphone");
            categoryRepository.save(category2);

            Category category3 = new Category();
            category3.setName("Roupas");
            category3.setCategoryKind("casuais");
            categoryRepository.save(category3);

            // Criar produtos
            Product product1 = new Product();
            product1.setName("Arroz");
            product1.setActive(true);
            List<Brand> product1Brands = new ArrayList<>();
            product1Brands.add(brand1);
            product1Brands.add(brand2);
            product1.setBrands(product1Brands);
            List<Category> product1Categories = new ArrayList<>();
            product1Categories.add(category1);
            product1Categories.add(category3);
            product1.setCategories(product1Categories);
            productRepository.save(product1);

            Product product2 = new Product();
            product2.setName("Feijão");
            product2.setActive(true);
            List<Brand> product2Brands = new ArrayList<>();
            product2Brands.add(brand2);
            product2.setBrands(product2Brands);
            List<Category> product2Categories = new ArrayList<>();
            product2Categories.add(category1);
            product2Categories.add(category2);
            product2.setCategories(product2Categories);
            productRepository.save(product2);

            Product product3 = new Product();
            product3.setName("Batata");
            product3.setActive(false);
            List<Brand> product3Brands = new ArrayList<>();
            product3Brands.add(brand3);
            product3.setBrands(product3Brands);
            List<Category> product3Categories = new ArrayList<>();
            product3Categories.add(category3);
            product3.setCategories(product3Categories);
            productRepository.save(product3);
           
        };
    }
}
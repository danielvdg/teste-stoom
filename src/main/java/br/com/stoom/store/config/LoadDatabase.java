package br.com.stoom.store.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.stoom.store.model.entity.Brand;
import br.com.stoom.store.model.entity.Category;
import br.com.stoom.store.model.entity.Price;
import br.com.stoom.store.model.entity.Product;
import br.com.stoom.store.repository.BrandRepository;
import br.com.stoom.store.repository.CategoryRepository;
import br.com.stoom.store.repository.PriceRepository;
import br.com.stoom.store.repository.ProductRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(
        ProductRepository productRepository,
        BrandRepository brandRepository,
        CategoryRepository categoryRepository,
        PriceRepository priceRepository) {
        return args -> {
            //Datas
            LocalDateTime date1 = LocalDateTime.of(2024, 1, 15, 10, 0);
            LocalDateTime date2 = LocalDateTime.of(2024, 6, 10, 10, 0);
            LocalDateTime date3 = LocalDateTime.of(2024, 11, 5, 10, 0);


            //marcas
            Brand brand1 = new Brand();
            brand1.setName("Tio Jõao");
            brandRepository.save(brand1);

            Brand brand2 = new Brand();
            brand2.setName("Carioca");
            brandRepository.save(brand2);

            Brand brand3 = new Brand();
            brand3.setName("batatão");
            brandRepository.save(brand3);

            //Categorias
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
            
             //preços
             Price price1 = new Price();
             price1.setPriceKind("Venda");
             price1.setAmount(500L);
             price1.setLot(100L);
             price1.setMadeIn(date1);
             price1.setExpirationDate(date3);
             priceRepository.save(price1);

             Price price2 = new Price();
             price2.setPriceKind("Promoção");
             price2.setAmount(300L);
             price2.setLot(50L);
             price2.setMadeIn(date2);
             price2.setExpirationDate(date3);
             priceRepository.save(price2);
 
             Price price3 = new Price();
             price3.setPriceKind("Atacado");
             price3.setAmount(1000L);
             price3.setLot(200L);
             price3.setMadeIn(date1);
             price3.setExpirationDate(date3);
             priceRepository.save(price3);

            //produtos
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
            List<Price> price1Products = new ArrayList<>();
            price1Products.add(price1);
            product1.setPrices(price1Products);
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
            List<Price> price2Products = new ArrayList<>();
            price2Products.add(price2);
            product2.setPrices(price2Products);
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
            List<Price> price3Products = new ArrayList<>();
            price3Products.add(price3);
            product3.setPrices(price3Products);
            productRepository.save(product3);   

        };
    }
}
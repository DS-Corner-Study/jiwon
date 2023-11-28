package com.springboot.jpa.data.repository;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void relationshipTest(){
        Product product=new Product();
        product.setName("펜");
        product.setPricee(2000);
        product.setStock(100);

        productRepository.save(product);

        Category category=new Category();
        category.setCode("S1");
        category.setName("도서");
        category.getProducts().add(product);

        categoryRepository.save(category);

        List<Product> products=categoryRepository.findById(1L).get().getProducts();

        for(Product foundProduct:products){
            System.out.println(product);
        }
    }
}

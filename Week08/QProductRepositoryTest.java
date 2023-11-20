package com.springboot.jpa.data.repository;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class QProductRepositoryTest {
    @Autowired
    QProductRepository qProductRepository;

    @Test
    public void quryDSLTest1(){
        Predicate predicate=QProduct.product.name.containsIgnoreCase("펜")
                .and(QProduct.product.price.between(1000,2500));

        Optional<Product> foundProduct=qProductRepository.findOne(predicate);

        if(foundProduct.isPresent()){
            Product product=foundProduct.get();
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }
}

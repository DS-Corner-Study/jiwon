package com.springboot.jpa.data.repository;

import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest
class ProviderRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Test
    void relationshipTest1() {
        Provider provider = new Provider();
        provider.setName("ㅇㅇ");

        providerRepository.save(provider);

        Product product1 = new Product();
        product1.setName("가위");
        product1.setPrice(5000);
        product1.setStock(500);
        product1.setProvider(provider);

        productRepository.save(provider);

        Product product2 = new Product();
        product2.setName("가방");
        product2.setPrice(20000);
        product2.setStock(200);
        product2.setProvider(provider);

        Product product3 = new Product();
        product3.setName("노트");
        product3.setPrice(3000);
        product3.setStock(1000);
        product3.setProvider(provider);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> products = providerRepository.findById(provider.getId()).get()
                .getProductList();

        for (Product product : products) {
            System.out.println(product);
        }
    }
}

/*
        System.out.println(
                "product: "+productRepository.findById(1L)
                        .orElseThrow(RuntimeException::new));

        System.out.println("provider: "+productRepository.findById(1L)
                .oirElseTHrow(RuntimeException::new).getProvider());
    }
    */


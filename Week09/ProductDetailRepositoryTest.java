package com.springboot.jpa.data.repository;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class ProductDetailRepositoryTest {
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveAndReadTest1(){
        Product product=new Product();
        product.setName("스프링 부트 JPA");
        product.setPrice(5000);
        product.setStock(500);
        productRepository.save(product);

        ProductDetail productDetail=new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("스프링 부트와 JPA를 함께 볼 수 있는 책");

        productDetailRepository.save(productDetail);

        System.out.println("saveProduct:"+productDetailRepository.findById(
                productDetail.getId()).get().getProducet());
        System.out.println("saveProductDetail:"+productDetailRepository.findById(
                productDetail.getId()).get());
    }
}

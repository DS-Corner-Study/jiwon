package com.springboot.jpa.service.impl;

import data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProductServiceImpl {

    @Service
    public class ProductServiceImpl implements ProductService{
        private final ProductDAO productDAO;

        @Autowired
        public ProductServiceImpl(ProductDAO productDAO){
            this.productDAO=productDAO;
        }

        @Override
        public ProductResponseDto getProduct(Long number){
            Product product=productDAO.selectProduct(number);

            ProductResponseDto productResponseDto=new ProductResponseDto();
            productResponseDto.setNumber(product.getNumber());
            productResponseDto.setName(product.getName());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setStock(product.getStock());

            return productResponseDto;
        }

        @Override
        public ProductResponseDto saveProduct(ProductDto productDto){
            Product product=new Product();
            product.setName(productDto.getName());
            product.setName(product.getName());
            product.setPrice(product.getPrice());
            product.setStock(product.getStock());
            product.setCreatedAt(LocalDateTime.now());
            product.setUpdatedAt(LocalDateTime.now());

            Product savedProduct=productDAO.insertProduct(product);

            ProductResponseDto productResponseDto=new ProductResponseDto();
            productResponseDto.setNumber(savedProduct.getNumber());
            productResponseDto.setName(savedProduct.getName());
            productResponseDto.setPrice(savedProduct.getPrice());
            productResponseDto.setStock(savedProduct.getStock());

            return productResponseDto;
        }

        @Override
        public ProductResponseDto changeProductName(Long number, String name) throws Exception{
            Product changedProduct=productDAO.updateProductName(number, name);

            ProductResponseDto productResponseDto=new ProductResponseDto();
            productResponseDto.setNumber(changedProduct.getNumber());
            productResponseDto.setName(changedProduct.getName());
            productResponseDto.setName(changedProduct.getPrice());
            productResponseDto.setName(changedProduct.getStock());

            return productResponseDto;
        }

        @Override
        public void deleteProduct(Long number) throws Exception{
            productDAO.deleteProduct(number);
        }
    }
}



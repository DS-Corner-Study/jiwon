package com.springboot.jpa.data.repository.support;

import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom{
        public ProductRepositoryCustomImpl(){
            super(Product.class);
        }
        @Override
        public List<Product> findByName(String name){
            QProduct product=QProduct.product;

            List<Product> productList=from(product)
                    .where(product.name.eq(name))
                    .select(product)
                    .fetch();

            return productList;
        }

    }


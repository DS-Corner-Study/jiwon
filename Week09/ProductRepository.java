package com.springboot.jpa.data.repository;


public interface ProductRepository {
    boolean existsByNumber(Long number);
    long countByName(String name);
    void deleteByNumber(Long number);
    long removeByName(String name);

    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    Product findByNumberIs(Long numnber);
    Product findByNumberequals(Long number);
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);

    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtIsNotNull();

    //And, Or
    Product findByNumberAndName(Long number, String name);
    Product findByNumberOrName(Long number, String name);

    //GreaterThan, LessThan, Between
    List<Product> findByPriceIsGreaterThan(Long price);
    List<Product> findByPriceGreaterThan(Long price);
    List<Product> findByPriceGreaterThanEqual(Long price);
    List<Product> findByPriceLessThan(Long price);
    List<Product> findByPriceLessThanEqual(Long price);
    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
    List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

    //부분일치 키워드
    List<Product> findByNameLike(String name);
    List<Product> findByNameIsLike(String name);

    //Asc:오름차순, Desc:내림차순
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);

    //Page<Product> findByName(String name, Pageable pageable);


}

package com.springboot.jpa.controller;

import com.springboot.jpa.data.dto.ProductResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(PoductController.class)    /*웹에서 사용되는 요청과 응답에 대한 테스트 수행*/
public class ProductControllerTest {

    @Autowired
    private MocMvc mockMvc;

    @MockBean               /*실제 빈 객체가 아닌 가짜(Mock)객체를 생성해서 주입하는 역할*/
    ProductServiceImpl productService;

    @Test           /*테스트코드가 포함되어 있다고 선언하는 어노테이션*/
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")   /*테스트 메서드 이름이 복잡하여 가독성이 떨어질 경우 이 어노테이션을 사용*/
    void getProductTest() throws Exception{
        given(productService.getProduct(123L)).willReturn(
                new ProductResponseDto(123L,"pen",5000,2000));

        String productId="123";

        mockMvc.perform(
                        get("/product?number="+productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath(
                        "$.number").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        verify(productService).getProduct(123L);
    }

}

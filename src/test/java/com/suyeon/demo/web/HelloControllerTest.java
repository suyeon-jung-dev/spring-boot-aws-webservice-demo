package com.suyeon.demo.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)    // SpringRunner 라는 실행자를 사용해서 spring-boot-test 와 junit 사이의 연결자 역할.
@WebMvcTest     // spring-test 어노테이션 중 웹(@Controller, @ControllerAdvice) 에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired  // spring 이 관리하고 있는 bean 주입
    private MockMvc mockMvc;    // 웹 api를 테스트할 때 사용. MockMvc 클래스로 http, get, post 에 대한 api 테스트 가능

    @Test
    public void responseHello() throws Exception {
        String hello = "hello";

        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))   // ockMvc를 통해 /hello 주소로 http get 요청
                .andExpect(MockMvcResultMatchers.status().isOk())   // 200 ok
                .andExpect(MockMvcResultMatchers.content().string(hello));  // 결과값이 예상한 값인지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        Integer amount = 1000;

        mockMvc.perform(
                MockMvcRequestBuilders.get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(name)))   // 응답받은 json 형태 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount", Matchers.is(amount)));
    }
}

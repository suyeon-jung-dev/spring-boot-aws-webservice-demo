package com.suyeon.demo.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() { // dto에 롬복을 통해 생성자로 저장한 값 == getter 값인지 테스트
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        Assertions.assertThat(dto.getName()).isEqualTo(name);   // org.assertj.core 라이브러리 사용!
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

    }
}

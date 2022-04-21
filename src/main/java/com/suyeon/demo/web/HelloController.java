package com.suyeon.demo.web;

import com.suyeon.demo.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller 를 json 으로 반환하게 만드는 어노테이션
// 메소드하나만 json 반환하도록 만들려면 @ResponseBody 사용
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam String name,
                                     @RequestParam Integer amount) {
        return new HelloResponseDto(name, amount);
    }
}

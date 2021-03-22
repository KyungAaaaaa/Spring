package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //GET방식 ~/hello 로 접속하게되면 아래 함수 실행
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; // resources:templates/hello.html로 연결되어 실행시킨다    }
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        // @RequestParam GET방식으로 name파라미터를 가져와 (String) name이라는 변수로 전달
        model.addAttribute("name", name);
        //viewResolver 가 화면을 연결
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //viewResolver를 사용하지않고 HttpMessageConverter 가 동작 - 기본 StringHttpMessageConverter
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        // 객체를 return하면 MappingJackson2HttpMessageConverter 가 동작 (JSON 반환)
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

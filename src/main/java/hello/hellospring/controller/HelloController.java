package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") //GET방식 ~/hello 로 접속하게되면 아래 함수 실행
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; // resources:templates/hello.html로 연결되어 실행시킨다    }
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name,Model model){
        // @RequestParam GET방식으로 name파라미터를 가져와 (String) name이라는 변수로 전달
        model.addAttribute("name",name);
        //viewResolver 가 화면을 연결
        return "hello-template";
    }
}

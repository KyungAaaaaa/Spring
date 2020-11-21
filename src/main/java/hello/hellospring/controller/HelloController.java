package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //GET방식 ~/hello 로 접속하게되면 아래 함수 실행
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; // resources:templates/hello.html로 연결되어 실행시킨다    }
    }
}

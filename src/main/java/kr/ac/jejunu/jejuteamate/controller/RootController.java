package kr.ac.jejunu.jejuteamate.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//에러 처리 컨트롤러
@Controller
public class RootController implements ErrorController {
    @GetMapping("/error")
    public String redirectRoot(){
        return "index.html";
    }

    public String getErrorPath() {
        return "/error";
    }
}

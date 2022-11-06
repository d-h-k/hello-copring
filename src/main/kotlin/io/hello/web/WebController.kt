package io.hello.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebController {

    @GetMapping
    fun index(model: Model):String {
        model.addAttribute("title", "sign in");
        return "index"
    }


    @GetMapping("/sign")
    fun sign(model: Model) : String {
        model.addAttribute("title", "sign in");
        return "sign"
    }

    @GetMapping("/login")
    fun login(model: Model) : String {
        model.addAttribute("title", "login");
        return "login"
    }
}
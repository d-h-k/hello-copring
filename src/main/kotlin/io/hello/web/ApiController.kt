package io.hello.web

import io.hello.web.user.UserInformation
import io.hello.web.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

//@RequiredArgsConstructor
@RequestMapping("/api/v0")
@RestController
class ApiController {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/hello")
    fun hello(): String {
        userRepository.findById(1);
        return "hell";
    }

    @PostMapping("/sign")
    fun signInRequest(
        module: Module,
        @RequestParam("email") email: String,
        @RequestParam("password") password: String
    ) {
        val savedUser = userRepository.save(UserInformation(email,password))
    }
}
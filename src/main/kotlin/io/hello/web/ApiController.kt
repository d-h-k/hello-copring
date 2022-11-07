package io.hello.web

import io.hello.web.user.UserInformation
import io.hello.web.user.UserRepository
import lombok.extern.slf4j.Slf4j
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

}
package io.hello.web.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.security.MessageDigest

@RequestMapping("/api/v0")
@RestController
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository


    @PostMapping()


    private fun crypto(securityString: String): String {
        val sha = MessageDigest.getInstance("SHA-256")
        val hex = sha.digest(securityString.toByteArray())
        return hex.fold("") { str, it -> str + "%02x".format() }

    }

    @PostMapping("/sign")
    fun signInRequest(
        model: Model,
        @RequestParam("id") id: String,
        @RequestParam("password") password: String
    ): String {
        print("id:$id")
        print("password:$password")
        val savedUser = userRepository.save(UserInformation(id, password))
        return "OK"
    }

}
package io.hello.web.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
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
        return hex.fold("") { str, fwe -> str + "%02x".format(fwe) }

    }

    @PostMapping("/sign")
    fun signIn(
        model: Model,
        @RequestParam("accoutId") accoutId: String,
        @RequestParam("password") password: String
    ): String {
        print("accoutId:$accoutId\n")
        print("input-password:$password\n")
        val encryptedString= crypto(password)
        val savedUser = userRepository.save(UserInformation(accoutId,encryptedString ))
        print("save-password:$encryptedString\n")
        print("savedUser:${savedUser.toString()}\n")
        return "OK"
    }

    @PostMapping("/login")
    fun login(
        model: Model,
        @RequestParam("accoutId") accoutId: String,
        @RequestParam("password") password: String
    ): String {
        val encryptedString= crypto(password)
        val savedUser = userRepository.findByAccoutId(accoutId)
        if(!savedUser.password.equals(encryptedString)) {
            return "login"
        }
        return "welcome"
    }

}
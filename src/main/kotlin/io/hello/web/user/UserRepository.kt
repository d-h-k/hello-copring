package io.hello.web.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository: JpaRepository<UserInformation, Long> {
    //fun findById(id:Long):UserInformation

    fun findByEmail(email:String):UserInformation

}
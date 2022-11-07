package io.hello.web.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserInformation, Long> {
    //fun findById(id:Long):UserInformation

    fun findByAccoutId(email: String): UserInformation

}
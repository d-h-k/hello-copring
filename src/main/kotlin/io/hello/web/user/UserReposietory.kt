package io.hello.web.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<UserInformation,Long> {
}
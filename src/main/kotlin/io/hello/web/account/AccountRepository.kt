package io.hello.web.account

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<AccountDomain, Long> {

}
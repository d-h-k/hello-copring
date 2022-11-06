package io.hello.web.account

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountDomain, Long> {
    
}
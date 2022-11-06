package io.hello.web.account

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class AccountDomain {
    @Id
    @GeneratedValue
    var id:Long ?=null
}
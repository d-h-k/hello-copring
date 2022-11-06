package io.hello.web.user

import io.hello.web.account.AccountDomain
import javax.persistence.*

@Entity
@Table(name = "user")
class UserInformation {

    @Id
    @GeneratedValue
    var id: Long? = null

    var email: String? = null
    var password: String? = null

    @Column
    @OneToOne
    var account: AccountDomain? = null;


}
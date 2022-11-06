package io.hello.web.user

import io.hello.web.account.AccountDomain
import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class UserInformation {

    @Id
    @GeneratedValue
    var id: Long? = null

    var email: String? = null
    var password: String? = null

    //@Column(name = "dg")
    @OneToOne()
    var account: AccountDomain? = null;


}
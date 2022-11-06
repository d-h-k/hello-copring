package io.hello.web.account

import io.hello.web.user.UserInformation
import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class AccountDomain {
    @Id
    @GeneratedValue
    var id:Long ?=null

    @OneToOne//(cascade = new asd:CascadeType[]  ={CascadeType.DETACH})
    var userInformation: UserInformation? = null

}
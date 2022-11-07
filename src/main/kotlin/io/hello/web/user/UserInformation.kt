package io.hello.web.user

import io.hello.web.account.AccountDomain
import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "users") //앗 너무 오랫만에 JPA 를 해서 이게 예약어인지 까먹고 있었다 ㅋㅋ
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class UserInformation {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "account_id")
    var accoutId: String? = null

    var password: String? = null

    //@Column(name = "dg")
    @OneToOne()
    var account: AccountDomain? = null;


    constructor(accoutId: String?, password: String?) {
        this.accoutId = accoutId
        this.password = password
    }
}
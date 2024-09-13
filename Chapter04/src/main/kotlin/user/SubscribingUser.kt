package com.around.user

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore("@")

}
//
//class FacebookUser(val accountId: Int) : User {
////    override val nickname = getFaceBookName(accountId) 만들어져있다고 가정
//}
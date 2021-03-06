package com.example.mvc.model.request

import com.fasterxml.jackson.annotation.JsonProperty

data class UserRequest ( //data클래스 생성자에서 변수 생성
        var name:String?=null,
        var age:Int?=null,
        var email:String?=null,
        var address:String?=null,

        @JsonProperty("phone_number")
        var phoneNumber:String?=null
)

package com.example.mvc.model.response

import com.example.mvc.model.request.UserRequest
import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse(
        var result:Result?=null,
        var description:String?=null,

        @JsonProperty("user")
        var userRequest: MutableList<UserRequest>?=null
)

data class Result(
        @JsonProperty("result_code")
        var resultCode:String?=null,
        @JsonProperty("result_message")
        var resultMessage:String?=null
)
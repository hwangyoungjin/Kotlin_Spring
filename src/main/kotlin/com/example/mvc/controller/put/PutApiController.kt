package com.example.mvc.controller.put

import com.example.mvc.model.request.UserRequest
import com.example.mvc.model.response.Result
import com.example.mvc.model.response.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping():String{
        return "put-mapping"
    }

    //list로 api 작성가능
    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        //0. Response
        return UserResponse().apply {
            //1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            //2. description
            this.description = "~~~~~~~~"
        }.apply {
            //3. user mutable list
            val userList = mutableListOf<UserRequest>()

            //put으로 들어온 유저
            userList.add(userRequest)

            //자체 생성
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address = "a aaaa"
                this.phoneNumber = "010-1111-1111"
            })
            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "b@gmail.com"
                this.address = "b bbbb"
                this.phoneNumber = "010-1111-1111"
            })

            //result에 넣기
            this.userRequest = userList
        }

    }
}
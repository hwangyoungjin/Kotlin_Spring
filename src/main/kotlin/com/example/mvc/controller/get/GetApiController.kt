package com.example.mvc.controller.get

import com.example.mvc.model.request.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {
    //http://~/api/hello
    //http://~/api/abcd
    @GetMapping("/hello","/abcd")
    fun hello(): String{
        return "hello kotlin"
    }

    //http://~/api/get-mapping/path-variable/youngjin
    @GetMapping("/get-mapping/path-variable/{name}")
    fun pathVariable(@PathVariable(value = "name") username: String): String{
        return username
    }
    //http://~/api/get-mapping/path-variable/youngjin
    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable2(@PathVariable name: String, @PathVariable age:Int): String{
        println("${name},${age}")
        return "name:" + name+", age :"+age
    }

    //http://~/api/get-mapping/path-variable?name=young&age=20
    //query 파라미터에는 대문자X -> '-'를 사용하기위해 value값 사용
    @GetMapping("/get-mapping/query-param")
    fun queryParam(@RequestParam name: String,
                @RequestParam(value = "user-age") ageNum:Int): String{
        return "name:" + name+", age :"+ageNum
    }

    // name age email address
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest{
        return userRequest
    }

    //query 파라미터에는 대문자X -> '-'를 사용하기위해 map사용
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String,Any>{
        return map
    }

}
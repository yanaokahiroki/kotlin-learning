package com.learning.chapter04.controllers

import com.learning.chapter04.models.Hello
import com.learning.chapter04.models.Name
import com.learning.chapter04.services.Greeter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeter")
class GreeterController(private val greeter: Greeter) {
  @GetMapping("/hello")
  fun hello(@RequestParam("name") name: String): Hello = Hello("Hello $name")

  @GetMapping("/hello/{name}")
  fun helloPathParam(@PathVariable("name") name: String): Hello = Hello("Hello $name")

  @PostMapping("/hello")
  fun helloByPost(@RequestBody request: Name): Hello = Hello("Hello ${request.name}")

  @GetMapping("/hello/service/{name}")
  fun helloByService(@PathVariable("name") name: String): Hello {
    val message = greeter.sayHello(name)
    return Hello(message)
  }
}

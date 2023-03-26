package com.learning.chapter04.services.impl

import com.learning.chapter04.services.Greeter
import org.springframework.stereotype.Component

@Component
class GreeterImpl : Greeter {
  override fun sayHello(name: String): String = "Hello $name"
}

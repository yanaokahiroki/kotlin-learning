package com.book.manager.presentation.config

import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

/**
 * HttpSession設定
 */
@EnableRedisHttpSession
class HttpSessionConfig {

  /**
   * Redis接続設定
   *
   * @return JedisConnectionFactory
   */
  @Bean
  fun connectionFactory(): JedisConnectionFactory {
    val redisStandaloneConfiguration = RedisStandaloneConfiguration().also {
      it.hostName = "kotlin-redis"
      it.port = 6379
    }

    return JedisConnectionFactory(redisStandaloneConfiguration)
  }
}

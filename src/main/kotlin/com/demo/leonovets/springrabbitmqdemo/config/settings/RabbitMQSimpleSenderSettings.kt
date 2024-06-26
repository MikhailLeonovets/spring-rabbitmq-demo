package com.demo.leonovets.springrabbitmqdemo.config.settings

import jakarta.annotation.PostConstruct
import org.apache.logging.log4j.LogManager
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties("demo.rabbitmq.sender")
@Configuration
data class RabbitMQSimpleSenderSettings(
  var exchange: String? = null,
  var routingKey: String? = null
) {
  @PostConstruct
  fun postConstruct() {
    logger.info(this.toString())
  }

  companion object {
    private val logger = LogManager.getLogger()
  }
}

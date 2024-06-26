package com.demo.leonovets.springrabbitmqdemo.config.settings

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties("demo.rabbitmq.sender")
@Configuration
data class RabbitMQSimpleSenderSettings(
  var exchange: String? = null,
  var routingKey: String? = null
)

package com.demo.leonovets.springrabbitmqdemo.config.settings

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties("demo.rabbitmq")
@Configuration
data class RabbitMQSettings(
  var queueName: String? = null,
  var topicExchangeName: String? = null,
  var routingKey: String? = null,
)

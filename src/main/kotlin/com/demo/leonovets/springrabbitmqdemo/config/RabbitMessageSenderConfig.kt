package com.demo.leonovets.springrabbitmqdemo.config

import com.demo.leonovets.springrabbitmqdemo.config.settings.RabbitMQSimpleSenderSettings
import com.demo.leonovets.springrabbitmqdemo.service.sender.RabbitMessageSender
import com.demo.leonovets.springrabbitmqdemo.service.sender.SimpleRabbitMessageSender
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMessageSenderConfig(
  private val rabbitMQSimpleSenderSettings: RabbitMQSimpleSenderSettings
) {
  @Bean
  fun simpleSender(rabbitTemplate: RabbitTemplate): RabbitMessageSender {
    return SimpleRabbitMessageSender(
      rabbitTemplate,
      rabbitMQSimpleSenderSettings.exchange!!,
      rabbitMQSimpleSenderSettings.routingKey!!
    )
  }
}

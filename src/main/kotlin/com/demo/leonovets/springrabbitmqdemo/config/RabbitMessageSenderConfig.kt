package com.demo.leonovets.springrabbitmqdemo.config

import com.demo.leonovets.springrabbitmqdemo.config.settings.FileRabbitSenderSettings
import com.demo.leonovets.springrabbitmqdemo.config.settings.RabbitMQSimpleSenderSettings
import com.demo.leonovets.springrabbitmqdemo.service.sender.FileRabbitMessageSender
import com.demo.leonovets.springrabbitmqdemo.service.sender.RabbitMessageSender
import com.demo.leonovets.springrabbitmqdemo.service.sender.SimpleJpgFileRabbitMessageSender
import com.demo.leonovets.springrabbitmqdemo.service.sender.SimpleRabbitMessageSender
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMessageSenderConfig(
  private val rabbitMQSimpleSenderSettings: RabbitMQSimpleSenderSettings,
  private val fileRabbitSenderSettings: FileRabbitSenderSettings
) {
  @Bean
  fun simpleSender(rabbitTemplate: RabbitTemplate): RabbitMessageSender {
    return SimpleRabbitMessageSender(
      rabbitTemplate,
      rabbitMQSimpleSenderSettings.exchange!!,
      rabbitMQSimpleSenderSettings.routingKey!!
    )
  }

  @Bean
  fun simpleJpgFileSender(rabbitTemplate: RabbitTemplate): FileRabbitMessageSender {
    return SimpleJpgFileRabbitMessageSender(
      rabbitTemplate,
      fileRabbitSenderSettings.fanoutSenderExchange!!
    )
  }
}

package com.demo.leonovets.springrabbitmqdemo.config

import com.demo.leonovets.springrabbitmqdemo.controller.RabbitMessageSenderController
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ControllerConfig(
  private val rabbitMessageSenderConfig: RabbitMessageSenderConfig
) {
  @Bean
  fun rabbitMessageSenderController(rabbitTemplate: RabbitTemplate): RabbitMessageSenderController {
    return RabbitMessageSenderController(
      rabbitMessageSenderConfig.simpleSender(rabbitTemplate),
      rabbitMessageSenderConfig.simpleJpgFileSender(rabbitTemplate)
    )
  }
}

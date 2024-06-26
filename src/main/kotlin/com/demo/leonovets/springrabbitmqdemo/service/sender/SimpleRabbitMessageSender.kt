package com.demo.leonovets.springrabbitmqdemo.service.sender

import org.springframework.amqp.rabbit.core.RabbitTemplate

class SimpleRabbitMessageSender(
  private val rabbitTemplate: RabbitTemplate,
  private val exchange: String,
  private val routingKey: String
) : RabbitMessageSender {
  override fun sendMessage(message: String) {
    rabbitTemplate.convertAndSend(exchange, routingKey, message)
  }
}

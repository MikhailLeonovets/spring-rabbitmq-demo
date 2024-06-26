package com.demo.leonovets.springrabbitmqdemo.service.sender

import org.apache.logging.log4j.LogManager
import org.springframework.amqp.rabbit.core.RabbitTemplate

class SimpleRabbitMessageSender(
  private val rabbitTemplate: RabbitTemplate,
  private val exchange: String,
  private val routingKey: String
) : RabbitMessageSender {
  override fun sendMessage(message: String) {
    logger.info("SimpleRabbitMessageSender send message: $message to exchange: $exchange with routingKey: $routingKey")
    rabbitTemplate.convertAndSend(exchange, routingKey, message)
  }

  companion object {
    private val logger = LogManager.getLogger()
  }
}

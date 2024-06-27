package com.demo.leonovets.springrabbitmqdemo.service.sender

import org.apache.logging.log4j.LogManager
import org.springframework.amqp.rabbit.core.RabbitTemplate
import java.io.File

class SimpleJpgFileRabbitMessageSender(
  private val rabbitTemplate: RabbitTemplate,
  private val exchange: String,
) : FileRabbitMessageSender {
  override fun sendFile(path: String) {
    logger.info("SimpleFileRabbitMessageSender send file: $path to exchange: $exchange")
    val fileBytes = File(path).readBytes()
    rabbitTemplate.convertAndSend(exchange, "", fileBytes)
  }

  companion object {
    private val logger = LogManager.getLogger()
  }
}

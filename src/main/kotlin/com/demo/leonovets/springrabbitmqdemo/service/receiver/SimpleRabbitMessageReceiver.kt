package com.demo.leonovets.springrabbitmqdemo.service.receiver

import org.apache.logging.log4j.LogManager

class SimpleRabbitMessageReceiver : RabbitMessageReceiver {
  override fun receiveMessage(message: String) {
    logger.info("Received message: $message")
  }

  companion object {
    private val logger = LogManager.getLogger()
  }
}

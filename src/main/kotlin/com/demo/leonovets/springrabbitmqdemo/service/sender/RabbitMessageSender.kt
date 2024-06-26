package com.demo.leonovets.springrabbitmqdemo.service.sender

interface RabbitMessageSender {
  fun sendMessage(message: String)
}

package com.demo.leonovets.springrabbitmqdemo.service.receiver

interface RabbitMessageReceiver {
  fun receiveMessage(message: String)
}

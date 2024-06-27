package com.demo.leonovets.springrabbitmqdemo.service.sender

interface FileRabbitMessageSender {
  fun sendFile(path: String)
}

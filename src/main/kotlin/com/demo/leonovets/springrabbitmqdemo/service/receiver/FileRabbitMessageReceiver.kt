package com.demo.leonovets.springrabbitmqdemo.service.receiver

interface FileRabbitMessageReceiver {
  fun receiveMessage(fileBytes: ByteArray)
}

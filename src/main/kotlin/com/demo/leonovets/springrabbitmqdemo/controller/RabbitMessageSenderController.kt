package com.demo.leonovets.springrabbitmqdemo.controller

import com.demo.leonovets.springrabbitmqdemo.model.SimpleMessage
import com.demo.leonovets.springrabbitmqdemo.service.sender.FileRabbitMessageSender
import com.demo.leonovets.springrabbitmqdemo.service.sender.RabbitMessageSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rabbit")
@RestController
class RabbitMessageSenderController(
  private val rabbitMessageSender: RabbitMessageSender,
  private val fileRabbitMessageSender: FileRabbitMessageSender
) {
  @PostMapping("/message")
  fun sendMessage(@RequestBody message: SimpleMessage) {
    rabbitMessageSender.sendMessage(message.toString())
  }

  @PostMapping("/file-message")
  fun sendJpgFile(@RequestBody jpgFilePath: String) {
    fileRabbitMessageSender.sendFile(jpgFilePath)
  }
}

package com.demo.leonovets.springrabbitmqdemo.config

import com.demo.leonovets.springrabbitmqdemo.config.settings.FileDirectoriesSettings
import com.demo.leonovets.springrabbitmqdemo.service.receiver.FileRabbitMessageReceiver
import com.demo.leonovets.springrabbitmqdemo.service.receiver.RabbitMessageReceiver
import com.demo.leonovets.springrabbitmqdemo.service.receiver.SimpleJpgFileRabbitMessageReceiver
import com.demo.leonovets.springrabbitmqdemo.service.receiver.SimpleRabbitMessageReceiver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMessageReceiverConfig(
  private val fileDirectoriesSettings: FileDirectoriesSettings
) {
  @Bean
  fun simpleReceiver(): RabbitMessageReceiver {
    return SimpleRabbitMessageReceiver()
  }

  @Bean
  fun simpleJpgFileReceiver(): FileRabbitMessageReceiver {
    return SimpleJpgFileRabbitMessageReceiver(
      receiverDirectoryPath = fileDirectoriesSettings.receiverDirectoryPath!!,
      fileName = fileDirectoriesSettings.receivedFileName!!
    )
  }
}

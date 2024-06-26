package com.demo.leonovets.springrabbitmqdemo.config

import com.demo.leonovets.springrabbitmqdemo.service.receiver.RabbitMessageReceiver
import com.demo.leonovets.springrabbitmqdemo.service.receiver.SimpleRabbitMessageReceiver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMessageReceiverConfig {
  @Bean
  fun simpleReceiver(): RabbitMessageReceiver {
    return SimpleRabbitMessageReceiver()
  }
}

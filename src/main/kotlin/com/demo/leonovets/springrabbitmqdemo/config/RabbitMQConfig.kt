package com.demo.leonovets.springrabbitmqdemo.config

import com.demo.leonovets.springrabbitmqdemo.config.settings.RabbitMQSettings
import org.apache.logging.log4j.LogManager
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig(
  private val rabbitMQSettings: RabbitMQSettings,
  private val rabbitMessageReceiverConfig: RabbitMessageReceiverConfig
) {
  @Bean
  fun queue(): Queue {
    return Queue(rabbitMQSettings.queueName, false)
  }

  @Bean
  fun topicExchange(): TopicExchange {
    return TopicExchange(rabbitMQSettings.topicExchangeName)
  }

  @Bean
  fun binding(): Binding {
    logger.info(
      "Binding queue (${queue().name}) to exchange (${topicExchange().name}) " +
        "with routing key (${rabbitMQSettings.routingKey})"
    )
    return BindingBuilder.bind(queue()).to(topicExchange()).with(rabbitMQSettings.routingKey)
  }

  @Bean
  fun listenerAdapter(): MessageListenerAdapter {
    return MessageListenerAdapter(rabbitMessageReceiverConfig.simpleReceiver(), "receiveMessage")
  }

  @Bean
  fun container(connectionFactory: ConnectionFactory): SimpleMessageListenerContainer {
    val container = SimpleMessageListenerContainer()
    container.connectionFactory = connectionFactory
    container.setQueueNames(rabbitMQSettings.queueName)
    container.setMessageListener(listenerAdapter())
    return container
  }

  companion object {
    private val logger = LogManager.getLogger()
  }
}

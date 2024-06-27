package com.demo.leonovets.springrabbitmqdemo.service.receiver

import org.apache.logging.log4j.LogManager
import java.io.File

class SimpleJpgFileRabbitMessageReceiver(
  private val receiverDirectoryPath: String,
  private val fileName: String
) : FileRabbitMessageReceiver {
  override fun receiveMessage(fileBytes: ByteArray) {
    logger.info("Received file you can find in sender-directory")
    val file = File("$receiverDirectoryPath/$fileName.jpg")
    file.delete()
    file.createNewFile()
    file.writeBytes(fileBytes)
  }

  companion object {
    private val logger = LogManager.getLogger()
  }
}

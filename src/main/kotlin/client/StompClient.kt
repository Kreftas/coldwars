/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package client

import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.simp.stomp.StompFrameHandler
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient
import java.lang.Exception
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

class StompClient {
  private lateinit var stompSession: StompSession
  private var subscription: StompSession.Subscription? = null


  fun connect(url: String) {
    val client = StandardWebSocketClient()
    val stompClient = WebSocketStompClient(client)
    stompClient.messageConverter = MappingJackson2MessageConverter()

    try {
      stompSession = stompClient.connectAsync(url, object : StompSessionHandlerAdapter() {
        override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
          println("Connected to WebSocket server")
        }

        override fun getPayloadType(headers: StompHeaders): Type {
          return ByteArray::class.java
        }
      }).get()
    } catch (e: Exception) {
      println("Connect failed $e")
    }

  }

  fun subscribe(topic: String, callback: (payload: String) -> Unit) {
    try {

      subscription = stompSession.subscribe(topic, object : StompFrameHandler {

        override fun getPayloadType(headers: StompHeaders): Type {
          return ByteArray::class.java
        }

        override fun handleFrame(headers: StompHeaders, payload: Any?) {
          println("ASDASD")
        }

      })

      println("Subscribed to $topic with $subscription")
    } catch (e: Exception) {
      println("Subscribe failed $e")
    }
  }

  fun send(destination: String, payload: Any) {
    try {
      stompSession.send(destination, payload)
      println("Sent message: $payload to $destination")
    } catch (e: Exception) {
      println("Send failed $e")
    }
  }

  // Additional methods for disconnecting, error handling, etc.
}


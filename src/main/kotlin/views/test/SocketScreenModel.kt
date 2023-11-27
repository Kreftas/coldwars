/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.test

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import client.ColdWarsClient
import kotlinx.coroutines.launch

class SocketScreenModel: ScreenModel {

  val client  = ColdWarsClient()

  fun connect() {
    screenModelScope.launch {
      client.connect()

    }
  }

  fun disconnect() {

  }

  fun sendHello() {
    client.sendHello()
  }

}
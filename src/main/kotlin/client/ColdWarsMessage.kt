package client

import kotlinx.serialization.Serializable

@Serializable
data class ColdWarsMessage(
  val msg: String
)
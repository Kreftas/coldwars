package framework

import kotlin.reflect.KClass

object CLog {

  private const val PREFIX = "LunaLog: "
  private const val ERROR = "ERROR : "

  fun d(any: Any?) {
    println("$PREFIX$any")
  }

  data class Builder(
    private var clazz: KClass<out Any>? = null,
    private var title: String? = null,
    private var msg: Any? = null,
    private var params: MutableMap<String, Any?> = mutableMapOf(),
  ) {
    private var log = PREFIX

    private fun addToLog(text: Any?) {
      text?.let {
        log = log.plus("$text: ")
      }
    }

    private fun addParams() {
      params.forEach { entry ->
        log = log.plus("${entry.key}: ${entry.value}  ")
      }
    }

    private fun removeLast() {
      val size = log.length
      log = log.removeRange(size - 2, size)
    }

    fun clazz(clazz: KClass<out Any>) = apply { this.clazz = clazz }
    fun title(title: String?) = apply { this.title = title }
    fun msg(msg: Any?) = apply { this.msg = msg }
    fun param(key: String, value: Any?) = apply { this.params[key] = value }
    fun log() {
      addToLog(clazz?.simpleName)
      addToLog(title)
      addToLog(msg)
      addParams()
      removeLast()
      println(log)
    }
  }

  fun e(msg: String) {
    println(ERROR + msg)
  }
}
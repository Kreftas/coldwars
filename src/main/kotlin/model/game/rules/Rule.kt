package model.game.rules


interface Rule {
  suspend fun execute()
  suspend fun undo()
}

data object EmptyRule: Rule {
  override suspend fun execute() {}
  override suspend fun undo() {}
}
package model.game

import model.game.rules.Rule

class RuleEnforcer {
  private val rules: MutableList<Rule> = mutableListOf()

  fun addRule(rule: Rule) {
    rules.add(rule)
  }

  fun removeLatest() {
    rules.takeLast(1)
  }

}
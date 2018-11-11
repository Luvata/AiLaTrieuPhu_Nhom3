package com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.model

data class Choice(val content: String, val correct: Boolean)
data class Question(val content: String, val choices: List<Choice>)

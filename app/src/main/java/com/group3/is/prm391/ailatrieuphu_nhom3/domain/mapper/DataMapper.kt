package com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.mapper

import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.Question
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.model.Choice
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.model.Question as ModelQuestion


object DataMapper {
    fun convertQuestionToQuestionModel(question: Question): ModelQuestion {
        return ModelQuestion(
            question.content,
            question.choices.mapIndexed { index, s ->
                Choice(s, index == question.ans)
            }
        )
    }
}
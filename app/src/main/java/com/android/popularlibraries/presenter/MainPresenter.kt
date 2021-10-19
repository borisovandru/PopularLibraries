package com.android.popularlibraries.presenter

import com.android.popularlibraries.model.CountersModel
import com.android.popularlibraries.view.IMainView

class MainPresenter(private val viewI: IMainView) {
    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(type: CounterType) {
        val dataFromModel = when (type) {
            CounterType.FIRST -> model.next(0)
            CounterType.SECOND -> model.next(1)
            CounterType.THIRD -> model.next(2)
        }
        viewI.setButtonText(type, dataFromModel.toString())
    }
}

enum class CounterType {
    FIRST,
    SECOND,
    THIRD
}

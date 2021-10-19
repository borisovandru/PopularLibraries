package com.android.popularlibraries.view

import com.android.popularlibraries.presenter.CounterType

interface IMainView {
    fun setButtonText(index: CounterType, text: String)
}

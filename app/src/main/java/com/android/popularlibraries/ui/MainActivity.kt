package com.android.popularlibraries.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.popularlibraries.R
import com.android.popularlibraries.databinding.ActivityMainBinding
import com.android.popularlibraries.presenter.CounterType
import com.android.popularlibraries.presenter.MainPresenter
import com.android.popularlibraries.view.IMainView

class MainActivity : AppCompatActivity(), IMainView {

    private var activityMainBinding: ActivityMainBinding? = null
    private var presenter: MainPresenter? = null

    override fun onStop() {
        presenter = null
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        presenter = MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding?.root)

        val listener = View.OnClickListener { view ->
            val type = when (view.id) {
                R.id.btn_counter1 -> CounterType.FIRST
                R.id.btn_counter2 -> CounterType.SECOND
                R.id.btn_counter3 -> CounterType.THIRD
                else -> throw IllegalStateException("Такой кнопки нет")
            }
            presenter?.counterClick(type)
        }

        activityMainBinding?.btnCounter1?.setOnClickListener(listener)
        activityMainBinding?.btnCounter2?.setOnClickListener(listener)
        activityMainBinding?.btnCounter3?.setOnClickListener(listener)
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(type: CounterType, text: String) {
        when (type) {
            CounterType.FIRST -> activityMainBinding?.btnCounter1?.text = text
            CounterType.SECOND -> activityMainBinding?.btnCounter2?.text = text
            CounterType.THIRD -> activityMainBinding?.btnCounter3?.text = text
        }
    }
}

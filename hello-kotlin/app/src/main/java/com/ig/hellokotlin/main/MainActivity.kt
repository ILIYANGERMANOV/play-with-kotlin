package com.ig.hellokotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ig.hellokotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    val presenter: MainContract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.initUI()
    }

    override fun setMessage(message: String) {
        tvMessage.text = message
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}

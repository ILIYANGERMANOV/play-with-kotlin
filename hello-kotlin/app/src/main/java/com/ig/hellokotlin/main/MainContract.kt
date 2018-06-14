package com.ig.hellokotlin.main

import com.ig.hellokotlin.BasePresenter
import com.ig.hellokotlin.BaseView

interface MainContract {
    interface View : BaseView {
        fun setMessage(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun initUI()
    }
}
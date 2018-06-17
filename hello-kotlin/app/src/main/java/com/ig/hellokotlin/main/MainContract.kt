package com.ig.hellokotlin.main

import com.ig.hellokotlin.core.BasePresenter
import com.ig.hellokotlin.core.BaseView

interface MainContract {
    interface View : BaseView {
        fun setMessage(message: String)
    }

    interface Presenter : BasePresenter {
        fun start()
    }
}
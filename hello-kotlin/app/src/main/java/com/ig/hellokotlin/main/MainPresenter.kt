package com.ig.hellokotlin.main

import com.ig.hellokotlin.core.Presenter

class MainPresenter(view: MainContract.View) :
        Presenter<MainContract.View>(view), MainContract.Presenter {

    override fun start() {
        view?.setMessage("Hello, Kotlin!")
    }
}

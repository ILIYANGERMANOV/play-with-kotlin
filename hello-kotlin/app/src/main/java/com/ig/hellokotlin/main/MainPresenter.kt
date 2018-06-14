package com.ig.hellokotlin.main

class MainPresenter(override var view: MainContract.View?) : MainContract.Presenter {
    override fun initUI() {
        view?.setMessage("Hello, Kotlin!")
    }

}

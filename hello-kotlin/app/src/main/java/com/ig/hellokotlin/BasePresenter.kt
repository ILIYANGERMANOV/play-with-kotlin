package com.ig.hellokotlin

interface BasePresenter<V : BaseView> {
    var view: V?

    fun onDestroy() {
        view = null
    }
}

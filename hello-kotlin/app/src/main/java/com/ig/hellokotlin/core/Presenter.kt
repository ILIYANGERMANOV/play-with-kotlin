package com.ig.hellokotlin.core

abstract class Presenter<V : BaseView>(view: V?) : BasePresenter {

    protected var view: V? = view
        get() {
            val isActive: Boolean = field?.UIActive ?: false
            if (isActive) {
                return field
            } else {
                return null
            }
        }

    override fun onDestroy() {
        view = null
    }
}

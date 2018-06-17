package com.ig.hellokotlin.core

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class MVPActivity<P : BasePresenter> : AppCompatActivity(), BaseView {

    override var UIActive: Boolean = false

    protected lateinit var presenter: P

    @LayoutRes
    abstract fun getContentLayout(): Int

    abstract fun initPresenter(applicationContext: Context): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBeforeSetContentView()
        setContentView(getContentLayout())
        presenter = initPresenter(applicationContext)
        onSetupUI()
    }

    override fun onStart() {
        super.onStart()
        UIActive = true
        onBusinessLogic()
    }

    /**
     * Empty stub
     */
    protected open fun onBeforeSetContentView() {
    }

    /**
     * Empty stub
     */
    protected open fun onSetupUI() {
    }

    /**
     * Empty stub
     */
    protected open fun onBusinessLogic() {
    }

    override fun onStop() {
        super.onStop()
        UIActive = false
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
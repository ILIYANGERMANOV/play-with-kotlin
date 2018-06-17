package com.ig.hellokotlin.main

import android.content.Context
import com.ig.hellokotlin.R
import com.ig.hellokotlin.core.MVPActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : MVPActivity<MainContract.Presenter>(), MainContract.View {
    override fun getContentLayout() = R.layout.activity_main

    override fun initPresenter(applicationContext: Context) = MainPresenter(this)

    override fun onBusinessLogic() {
        presenter.start()
    }

    override fun setMessage(message: String) {
        tvMessage.text = message
    }
}

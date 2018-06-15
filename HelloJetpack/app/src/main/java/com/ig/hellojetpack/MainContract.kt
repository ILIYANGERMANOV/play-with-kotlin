package com.ig.hellojetpack

import android.arch.lifecycle.LiveData

interface MainContract {
    interface View {
        fun showLoading()

        fun displayBody(body: String)

        fun displayEmptyState()

        fun displayError()
    }


    interface Presenter {
        fun getBody(): LiveData<Resource<String>>

        fun init()

        fun fetch()
    }

    interface Model {
        fun fetchData(url: String, callback: Callback)

        interface Callback {
            fun onFetched(data: String?)

            fun onError()
        }
    }
}
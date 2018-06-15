package com.ig.hellojetpack

import android.content.Context
import android.os.Handler
import java.util.*

class MainModel(val context: Context) : MainContract.Model {
    private var counter = 0
    override fun fetchData(url: String, callback: MainContract.Model.Callback) {
        Handler().postDelayed({
            if (counter++ == 0) {
                callback.onError()
            } else {
                callback.onFetched(if (Random().nextBoolean()) "My awesome data!" else null)
                counter = 0;
            }
        }, 3000)
    }

}
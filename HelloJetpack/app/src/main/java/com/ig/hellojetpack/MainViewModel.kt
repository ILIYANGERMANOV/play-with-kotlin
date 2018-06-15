package com.ig.hellojetpack

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel(private val model: MainContract.Model) : ViewModel(), MainContract.Presenter {
    private val body: MutableLiveData<Resource<String>> = MutableLiveData()

    override fun getBody(): LiveData<Resource<String>> {
        return body
    }

    override fun fetch() {
        body.value = Resource(Status.LOADING)
        model.fetchData("http://zamunda.net/browse.php", object : MainContract.Model.Callback {
            override fun onFetched(data: String?) {
                body.postValue(Resource(Status.SUCCESS, data))
            }

            override fun onError() {
                body.postValue(Resource(Status.ERROR))
            }
        })
    }

    override fun init() {
        fetch()
    }

}
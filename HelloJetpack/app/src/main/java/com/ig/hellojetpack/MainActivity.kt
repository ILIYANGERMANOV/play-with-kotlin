package com.ig.hellojetpack

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ig.hellojetpack.Status.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
        MainContract.View {
    lateinit var presenter: MainContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = MainModel(this)
        presenter = ViewModelProviders.of(this, MainViewModelFactory(model))
                .get(MainViewModel::class.java)
        subscribeUi()
        btnFetch.setOnClickListener {
            presenter.fetch()
        }
        presenter.init()
    }

    private fun subscribeUi() {
        presenter.getBody().observe(this, Observer { it ->
            run {
                it?.let {
                    handleCases(it)
                }
            }

        })
    }

    private fun MainActivity.handleCases(it: Resource<String>) {
        with(it) {
            when (status) {
                SUCCESS -> {
                    if (data != null) {
                        displayBody(data)
                    } else {
                        displayEmptyState()
                    }
                }
                LOADING -> showLoading()
                ERROR -> displayError()
            }
        }
    }

    class MainViewModelFactory(private val model: MainContract.Model) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(model) as T
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        tvMessage.visibility = View.GONE
        btnFetch.setEnabled(false)
    }

    override fun displayBody(body: String) {
        hideLoading()
        tvMessage.text = body
        tvMessage.setTextColorRes(android.R.color.black)
    }

    override fun displayEmptyState() {
        hideLoading()
        tvMessage.text = getString(R.string.msg_empty_state)
        tvMessage.setTextColorRes(android.R.color.black)
    }

    override fun displayError() {
        hideLoading()
        tvMessage.text = getString(R.string.msg_error)
        tvMessage.setTextColorRes(android.R.color.holo_red_light)
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
        tvMessage.visibility = View.VISIBLE
        btnFetch.setEnabled(true)
    }
}

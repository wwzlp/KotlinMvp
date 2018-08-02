package com.zmsoft.kotlindemo.ui.main

import android.widget.Toast
import com.google.gson.Gson
import com.zmsoft.kotlindemo.App
import com.zmsoft.kotlindemo.base.BasePresenter
import com.zmsoft.kotlindemo.network.NewsResult
import com.zmsoft.kotlindemo.network.RetrofitService
import es.dmoral.toasty.Toasty
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun getText() {

        RetrofitService.newsApi.getTopNews("us" , "" , "897e7d6b04dd4b79a23613fd8c9d820b")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<NewsResult>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: NewsResult) {
                        getView()?.showText(Gson().toJson(t))
                    }

                    override fun onError(e: Throwable) {
                        Toasty.error(App.instance!!.applicationContext , e.message?:"" , Toast.LENGTH_SHORT).show()
                    }

                })
    }

}
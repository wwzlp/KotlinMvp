package com.zmsoft.kotlindemo.network

import io.reactivex.observers.DisposableObserver

class ApiCallBack<T> : DisposableObserver<T>() {
    override fun onNext(t: T) {
    }

    override fun onComplete() {
    }


    override fun onError(e: Throwable) {
    }

}
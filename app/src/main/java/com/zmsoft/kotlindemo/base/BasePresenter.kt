package com.zmsoft.kotlindemo.base

import java.lang.ref.SoftReference

abstract class BasePresenter<T : IBaseView> {

    protected var viewRefrence: SoftReference<T>? = null

    /**
     * 关联视图
     *
     * @param view
     */
    fun attachView(view: T) {
        viewRefrence = SoftReference(view)
    }

    /**
     * 接触视图关联
     */
    fun detachView() {
        viewRefrence?.clear()
    }

    fun getView(): T? {
        return viewRefrence?.get()
    }

}
package com.zmsoft.kotlindemo.base

interface IBaseMvpActivity<out T : BasePresenter<*>> : IBaseActivity {
    /**
     * 获取presenter
     * @return
     */
    fun getPresenter(): T
}
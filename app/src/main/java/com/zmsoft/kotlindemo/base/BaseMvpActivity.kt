package com.zmsoft.kotlindemo.base

abstract class BaseMvpActivity :AbstractBaseActivity() , IBaseView{
    override fun showLoading() {
        showLoading("请稍后")
    }

    override fun showLoading(msg: String) {
    }

    override fun hideLoading() {

    }
}
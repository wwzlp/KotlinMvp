package com.zmsoft.kotlindemo.ui.main

import com.zmsoft.kotlindemo.base.BasePresenter

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun getText() {
        getView()?.showText("MVP KOTLIN")
    }

}
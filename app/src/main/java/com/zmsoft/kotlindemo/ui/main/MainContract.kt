package com.zmsoft.kotlindemo.ui.main

import com.zmsoft.kotlindemo.base.IBaseView

interface MainContract {
    interface View :IBaseView{
        fun showText(msg:String)
    }

    interface Presenter{
        fun getText()
    }
}
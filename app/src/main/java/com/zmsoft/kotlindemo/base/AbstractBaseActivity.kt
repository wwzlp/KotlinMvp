package com.zmsoft.kotlindemo.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class AbstractBaseActivity : AppCompatActivity(), IBaseActivity {

    protected var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
    }

    override fun initViewAndEvent() {
        initViews()
        initEvents()
    }

    override fun finish() {
        super.finish()
        //TODO 移除栈
    }

}
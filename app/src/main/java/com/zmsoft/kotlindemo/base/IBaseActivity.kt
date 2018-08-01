package com.zmsoft.kotlindemo.base

interface IBaseActivity {
    fun getContentLayoutId():Int

    /**
     * 初始化变量
     */
    fun initVariables()

    /**
     * 初始化控件
     */
    fun initViews()

    /**
     * 初始化事件
     */
    fun initEvents()

    /**
     * 初始化视图控件和事件
     */
    fun initViewAndEvent()

    /**
     * 初始化数据
     */
    fun initData()
}
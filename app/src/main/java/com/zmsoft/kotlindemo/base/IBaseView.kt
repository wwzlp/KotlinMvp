package com.zmsoft.kotlindemo.base

interface IBaseView{
    /**
     * 显示加载框
     */
    fun showLoading()

    /**
     * 显示自定义内容加载框
     *
     * @param msg
     */
    fun showLoading(msg:String)

    /**
     * 隐藏加载框
     */
    fun hideLoading()
}
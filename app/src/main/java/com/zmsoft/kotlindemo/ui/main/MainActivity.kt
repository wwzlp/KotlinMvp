package com.zmsoft.kotlindemo.ui.main

import com.zmsoft.kotlindemo.R
import com.zmsoft.kotlindemo.base.BaseMvpActivity
import com.zmsoft.kotlindemo.base.IBaseMvpActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity(), IBaseMvpActivity<MainPresenter>, MainContract.View {
    private var mPresenter: MainPresenter? = null

    override fun showText(msg: String) {
        text.text = "MVP KOTLIN"
    }

    override fun getPresenter(): MainPresenter {
        if (mPresenter == null) {
            mPresenter = MainPresenter()
        }
        return mPresenter as MainPresenter
    }

    override fun getContentLayoutId() = R.layout.activity_main

    override fun initVariables() {
    }

    override fun initViews() {
    }

    override fun initEvents() {
    }

    override fun initData() {
        getPresenter().getText()
    }

}

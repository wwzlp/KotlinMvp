package com.zmsoft.kotlindemo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import com.zmsoft.kotlindemo.base.BasePresenter
import com.zmsoft.kotlindemo.base.IBaseActivity
import com.zmsoft.kotlindemo.base.IBaseMvpActivity
import com.zmsoft.kotlindemo.base.IBaseView

class ActivityLifecycleManager : Application.ActivityLifecycleCallbacks {


    override fun onActivityCreated(activity: Activity?, bundle: Bundle?) {
        if (activity is IBaseActivity) {
            val iBaseActivity: IBaseActivity = activity
            activity.setContentView(LayoutInflater.from(activity).inflate(iBaseActivity.getContentLayoutId(), null))
            if (activity is IBaseMvpActivity<*>) {
                ( activity as IBaseMvpActivity<BasePresenter<IBaseView>>).getPresenter().attachView(activity as IBaseView)
            }
            iBaseActivity.initVariables()
            iBaseActivity.initViewAndEvent()
            //TODO 加入管理栈

        }
    }

    override fun onActivityPaused(p0: Activity?) {
    }

    override fun onActivityResumed(p0: Activity?) {
    }

    override fun onActivityStarted(p0: Activity?) {
        if (p0 is IBaseActivity) {
            val iBaseActivity: IBaseActivity = p0
            iBaseActivity.initData()
        }
    }

    override fun onActivityDestroyed(p0: Activity?) {
        if (p0 is IBaseActivity) {
            if (p0 is IBaseMvpActivity<*>) {
                (p0 as IBaseMvpActivity<BasePresenter<IBaseView>>).getPresenter().attachView(p0 as IBaseView)
            }
            //TODO 移除管理栈

        }
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStopped(p0: Activity?) {
    }
}
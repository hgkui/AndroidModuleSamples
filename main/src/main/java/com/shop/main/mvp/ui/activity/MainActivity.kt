package com.shop.main.mvp.ui.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.jess.arms.di.component.AppComponent
import com.shop.arms.app.base.RouterUrl
import com.shop.main.R
import com.shop.main.di.Module.MainModule
import com.shop.main.di.component.DaggerMainComponent
import com.shop.main.mvp.contract.MainContract
import com.shop.main.mvp.presenter.MainPresenter
import com.shop.main.mvp.ui.BaseArmActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : BaseArmActivity<MainPresenter>(), MainContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent.builder()
            .appComponent(appComponent)
            .mainModule(MainModule(this))
            .build()
            .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configClickListener(tv)
    }

    @Subscribe
    fun onMessageEvent(event: String) {
        tv.text = event
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.tv -> {
                ARouter.getInstance().build(RouterUrl.TEST_MINE).navigation()
            }
        }
    }
}
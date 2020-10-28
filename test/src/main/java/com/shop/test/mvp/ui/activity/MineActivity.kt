package com.shop.test.mvp.ui.activity

import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jess.arms.di.component.AppComponent
import com.shop.arms.app.base.RouterUrl
import com.shop.test.R
import com.shop.test.di.component.DaggerMineComponent
import com.shop.test.di.module.MineModule
import com.shop.test.mvp.contract.MineContract
import com.shop.test.mvp.presenter.MinePresenter
import kotlinx.android.synthetic.main.activity_mine.*
import org.greenrobot.eventbus.EventBus


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/23/2020 17:01
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
@Route(path = RouterUrl.TEST_MINE)
class MineActivity : BaseArmActivity<MinePresenter>(),
    MineContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMineComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .mineModule(MineModule(this))
            .build()
            .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_mine //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configClickListener(tv)
        EventBus.getDefault().post("测试")
    }
    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.tv -> {
                ARouter.getInstance().build(RouterUrl.APP_HOME).navigation()
            }
        }
    }

}

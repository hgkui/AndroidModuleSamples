package com.shop.main.di.component
import dagger.Component
import com.jess.arms.di.component.AppComponent


import com.jess.arms.di.scope.ActivityScope
import com.shop.main.di.Module.TestModule
import com.shop.main.mvp.ui.activity.TestActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/23/2020 16:50
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(TestModule::class), dependencies = arrayOf(AppComponent::class))
interface TestComponent {
    fun inject(activity: TestActivity)
}

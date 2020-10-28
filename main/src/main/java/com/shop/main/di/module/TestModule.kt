package com.shop.main.di.Module
import com.jess.arms.di.scope.ActivityScope
import com.shop.main.mvp.contract.TestContract
import com.shop.main.mvp.model.TestModel

import dagger.Module
import dagger.Provides



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
@Module
//构建TestModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class TestModule(private val view: TestContract.View) {
    @ActivityScope
    @Provides
    fun provideTestView(): TestContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideTestModel(model: TestModel): TestContract.Model {
        return model
    }
}

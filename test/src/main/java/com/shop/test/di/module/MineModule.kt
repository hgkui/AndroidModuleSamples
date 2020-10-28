package com.shop.test.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.shop.test.mvp.contract.MineContract
import com.shop.test.mvp.model.MineModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/23/2020 17:02
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建MineModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MineModule(private val view: MineContract.View) {
    @ActivityScope
    @Provides
    fun provideMineView(): MineContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMineModel(model: MineModel): MineContract.Model {
        return model
    }
}

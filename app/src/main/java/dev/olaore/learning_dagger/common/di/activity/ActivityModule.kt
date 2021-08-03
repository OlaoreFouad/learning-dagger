package dev.olaore.learning_dagger.common.di.activity

import android.app.Activity
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.screens.activities.BaseActivity
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator

@Module
class ActivityModule(
    private val appComponent: AppComponent,
    private val activity: BaseActivity
) {

    @Provides
    fun activity(): Activity = activity

    @Provides
    fun screensNavigator(activity: Activity) = ScreensNavigator(activity)

    @Provides
    fun layoutInflater(activity: Activity) = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()

}
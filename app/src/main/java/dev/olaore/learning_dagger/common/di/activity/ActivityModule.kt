package dev.olaore.learning_dagger.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigatorImpl

@Module
abstract class ActivityModule {

    @Binds
    abstract fun screensNavigator(
        screensNavigatorImpl: ScreensNavigatorImpl
    ): ScreensNavigator

    companion object {
        @Provides
        fun layoutInflater(activity: AppCompatActivity): LayoutInflater =
            LayoutInflater.from(activity)

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }


}
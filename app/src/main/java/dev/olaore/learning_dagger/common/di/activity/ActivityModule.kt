package dev.olaore.learning_dagger.common.di.activity

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.screens.activities.BaseActivity
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator

@Module
object ActivityModule {

    @Provides
    @ActivityScope
    fun screensNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)

    @Provides
    fun layoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager


}
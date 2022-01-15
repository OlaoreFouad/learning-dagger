package dev.olaore.learning_dagger.common.di.activity

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigatorImpl

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun screensNavigator(
        screensNavigatorImpl: ScreensNavigatorImpl
    ): ScreensNavigator

    companion object {

        @Provides
        fun provideAppCompatActivity(activity: Activity): AppCompatActivity
             = activity as AppCompatActivity

        @Provides
        fun layoutInflater(activity: Activity): LayoutInflater =
            LayoutInflater.from(activity)

        @ActivityScoped
        @Provides
        fun fragmentManager(activity: AppCompatActivity): FragmentManager = activity.supportFragmentManager

    }


}
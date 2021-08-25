package dev.olaore.learning_dagger.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Component
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator

@ActivityScope
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun screensNavigator(): ScreensNavigator

    fun layoutInflater(): LayoutInflater

    fun fragmentManager(): FragmentManager

    fun stackoverflowApi(): StackoverflowApi
    
    fun activity(): AppCompatActivity

}
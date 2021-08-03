package dev.olaore.learning_dagger

import android.app.Application
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.common.di.app.AppModule
import dev.olaore.learning_dagger.common.di.app.DaggerAppComponent

class MyApplication: Application() {

    val root: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}
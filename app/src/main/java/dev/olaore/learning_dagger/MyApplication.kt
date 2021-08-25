package dev.olaore.learning_dagger

import android.app.Application
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.common.di.app.AppModule
import dev.olaore.learning_dagger.common.di.app.DaggerAppComponent

class MyApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}
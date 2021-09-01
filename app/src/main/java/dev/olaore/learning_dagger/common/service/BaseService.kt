package dev.olaore.learning_dagger.common.service

import android.app.Service
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.common.di.service.ServiceModule

abstract class BaseService : Service() {

    private val appComponent: AppComponent
        get() = (application as MyApplication).appComponent

    val serviceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }

}
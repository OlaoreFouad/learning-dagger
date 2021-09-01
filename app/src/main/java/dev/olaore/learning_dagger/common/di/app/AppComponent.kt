package dev.olaore.learning_dagger.common.di.app

import android.app.Application
import dagger.Component
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.common.di.activity.ActivityModule
import dev.olaore.learning_dagger.common.di.service.ServiceComponent
import dev.olaore.learning_dagger.common.di.service.ServiceModule
import dev.olaore.learning_dagger.networking.StackoverflowApi
import retrofit2.Retrofit

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(
        module: ActivityModule
    ): ActivityComponent

    fun newServiceComponent(
        module: ServiceModule
    ): ServiceComponent

}
package dev.olaore.learning_dagger.common.di.app

import dagger.Component
import dev.olaore.learning_dagger.networking.StackoverflowApi
import retrofit2.Retrofit

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun retrofit(): Retrofit

    fun stackoverflowApi(): StackoverflowApi

}
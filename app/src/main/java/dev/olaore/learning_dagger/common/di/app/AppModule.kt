package dev.olaore.learning_dagger.common.di.app

import android.app.Application
import androidx.annotation.UiThread
import dagger.Module
import dagger.Provides
import dev.olaore.learning_dagger.Constants
import dev.olaore.learning_dagger.common.di.app.qualifiers.Retrofit1
import dev.olaore.learning_dagger.common.di.app.qualifiers.Retrofit2
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.networking.UrlProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(
    val application: Application
) {

    @Provides
    @AppScope
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(urlProvider.baseUrl)
        .build()

    @Provides
    @AppScope
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(urlProvider.otherBaseUrl)
        .build()

    @Provides
    @AppScope
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit): StackoverflowApi =
        retrofit.create(StackoverflowApi::class.java)

    @Provides
    fun application() = application

}
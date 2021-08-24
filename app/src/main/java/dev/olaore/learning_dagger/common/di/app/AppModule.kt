package dev.olaore.learning_dagger.common.di.app

import android.app.Application
import androidx.annotation.UiThread
import dagger.Module
import dagger.Provides
import dev.olaore.learning_dagger.Constants
import dev.olaore.learning_dagger.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(
    val application: Application
) {

    @Provides
    @AppScope
    fun retrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    @Provides
    @AppScope
    fun stackoverflowApi(retrofit: Retrofit): StackoverflowApi =
        retrofit.create(StackoverflowApi::class.java)

    @Provides
    @AppScope
    fun application(): Application = application

}
package dev.olaore.learning_dagger

import android.app.Application
import dev.olaore.learning_dagger.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()

    val stackoverflowApi: StackoverflowApi
        get() = retrofit.create(StackoverflowApi::class.java)

    override fun onCreate() {
        super.onCreate()
    }

}
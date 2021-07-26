package dev.olaore.learning_dagger

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()

    override fun onCreate() {
        super.onCreate()
    }

}
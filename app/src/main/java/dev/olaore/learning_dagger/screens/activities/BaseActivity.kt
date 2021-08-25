package dev.olaore.learning_dagger.screens.activities

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.di.*
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.common.di.activity.ActivityModule
import dev.olaore.learning_dagger.common.di.activity.DaggerActivityComponent
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.common.di.app.AppModule
import dev.olaore.learning_dagger.common.di.app.DaggerAppComponent
import dev.olaore.learning_dagger.common.di.presentation.DaggerPresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(
                ActivityModule(
                    appComponent, this
                )
            )
            .build()
    }

    private val component: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }

    protected val injector get() = component


}
package dev.olaore.learning_dagger.screens.activities

import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.di.*
import dev.olaore.learning_dagger.common.di.Injector
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.common.di.activity.ActivityModule
import dev.olaore.learning_dagger.common.di.activity.DaggerActivityComponent
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.common.di.presentation.DaggerPresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    val appComponent: AppComponent
        get() = (application as MyApplication).root

    private val activityComponent: ActivityComponent by lazy {
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

    val injector: Injector
        get() = Injector(component)


}
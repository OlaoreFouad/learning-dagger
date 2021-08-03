package dev.olaore.learning_dagger.screens.fragments

import androidx.fragment.app.Fragment
import dev.olaore.learning_dagger.common.di.*
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.common.di.activity.ActivityModule
import dev.olaore.learning_dagger.common.di.activity.DaggerActivityComponent
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.common.di.presentation.DaggerPresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationModule
import dev.olaore.learning_dagger.screens.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val appComponent: AppComponent
        get() = (requireActivity() as BaseActivity).appComponent

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(
                ActivityModule(
                    appComponent,
                    requireActivity() as BaseActivity
                )
            )
            .build()
    }

    private val root: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(
                PresentationModule(
                    activityComponent
                )
            )
            .build()
    }

    val injector: Injector
        get() = Injector(root)

}
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

    private val root: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(
                PresentationModule(
                    (requireActivity() as BaseActivity).activityComponent
                )
            )
            .build()
    }

    protected val injector get() = root
}
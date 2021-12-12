package dev.olaore.learning_dagger.screens.fragments

import androidx.fragment.app.Fragment
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationModule
import dev.olaore.learning_dagger.screens.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val activityComponent: ActivityComponent
        get() = (requireActivity() as BaseActivity).activityComponent

    private val root: PresentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule(this))
    }

    protected val injector get() = root

}
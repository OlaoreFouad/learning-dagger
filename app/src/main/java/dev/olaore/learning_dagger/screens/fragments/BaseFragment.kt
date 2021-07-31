package dev.olaore.learning_dagger.screens.fragments

import androidx.fragment.app.Fragment
import dev.olaore.learning_dagger.screens.activities.BaseActivity
import dev.olaore.learning_dagger.screens.common.di.Injector
import dev.olaore.learning_dagger.screens.common.di.PresentationCompositionRoot

open class BaseFragment : Fragment() {

    val root: PresentationCompositionRoot
        get() = (PresentationCompositionRoot(
            (requireActivity() as BaseActivity).activityCompositionRoot
        ))

    val injector: Injector
        get() = Injector(root)

}
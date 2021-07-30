package dev.olaore.learning_dagger.screens.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.AppCompositionRoot
import dev.olaore.learning_dagger.screens.activities.ActivityCompositionRoot
import dev.olaore.learning_dagger.screens.activities.BaseActivity
import dev.olaore.learning_dagger.screens.common.composition.PresentationCompositionRoot

open class BaseFragment : Fragment() {

    val root: PresentationCompositionRoot
        get() = (PresentationCompositionRoot(
            (requireActivity() as BaseActivity).activityCompositionRoot
        ))

}
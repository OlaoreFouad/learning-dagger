package dev.olaore.learning_dagger.screens.activities

import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.AppCompositionRoot
import dev.olaore.learning_dagger.screens.common.composition.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot: AppCompositionRoot
        get() = (application as MyApplication).root

    val activityCompositionRoot: ActivityCompositionRoot by lazy {
        ActivityCompositionRoot(
            appCompositionRoot,
            this
        )
    }

    val root: PresentationCompositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

}
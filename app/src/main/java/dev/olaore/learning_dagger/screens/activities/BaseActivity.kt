package dev.olaore.learning_dagger.screens.activities

import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.AppCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot: AppCompositionRoot
        get() = (application as MyApplication).root

    val root: ActivityCompositionRoot by lazy {
        ActivityCompositionRoot(
            appCompositionRoot,
            this
        )
    }

}
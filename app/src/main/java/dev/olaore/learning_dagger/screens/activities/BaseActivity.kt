package dev.olaore.learning_dagger.screens.activities

import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.AppCompositionRoot

open class BaseActivity : AppCompatActivity() {

    val root: AppCompositionRoot
        get() = (application as MyApplication).root

}
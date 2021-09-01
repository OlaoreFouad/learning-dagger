package dev.olaore.learning_dagger.screens.common.dialogs

import android.app.Application
import androidx.fragment.app.DialogFragment
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.screens.activities.BaseActivity

open class BaseDialog() : DialogFragment() {

    private val activityComponent: ActivityComponent
        get() = (requireActivity() as BaseActivity).activityComponent

    val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

}
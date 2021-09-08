package dev.olaore.learning_dagger.screens.common.navigation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import dev.olaore.learning_dagger.screens.viewmodels.ViewModelActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject
    constructor(
        private val activity: AppCompatActivity
    ) : ScreensNavigator {

    override fun navigateBack() {
        activity.onBackPressed()
    }

    override fun toQuestionDetails(id: String) {
        QuestionDetailsActivity.start(activity.applicationContext, id)
    }

    override fun toViewModel() {
        ViewModelActivity.start(activity.applicationContext)
    }

}
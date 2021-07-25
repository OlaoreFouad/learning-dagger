package dev.olaore.learning_dagger.screens.common.navigation

import android.app.Activity
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator(
    private val activity: Activity
) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(id: String) {
        QuestionDetailsActivity.start(activity.applicationContext, id)
    }

}
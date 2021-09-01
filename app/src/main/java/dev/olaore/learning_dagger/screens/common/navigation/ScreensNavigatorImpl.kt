package dev.olaore.learning_dagger.screens.common.navigation

import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
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

}
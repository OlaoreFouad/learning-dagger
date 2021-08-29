package dev.olaore.learning_dagger.screens.common.navigation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.common.di.activity.ActivityScope
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigator @Inject
    constructor(
        private val activity: AppCompatActivity
    ) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(id: String) {
        QuestionDetailsActivity.start(activity.applicationContext, id)
    }

}
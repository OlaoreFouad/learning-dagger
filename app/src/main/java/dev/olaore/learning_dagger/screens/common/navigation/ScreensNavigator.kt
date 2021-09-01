package dev.olaore.learning_dagger.screens.common.navigation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.common.di.activity.ActivityScope
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

interface ScreensNavigator {

    fun navigateBack()

    fun toQuestionDetails(id: String)

}
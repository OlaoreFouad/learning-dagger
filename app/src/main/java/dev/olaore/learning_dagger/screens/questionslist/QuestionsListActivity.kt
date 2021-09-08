package dev.olaore.learning_dagger.screens.questionslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.Constants
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.R
import dev.olaore.learning_dagger.models.Result
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.questions.Question
import dev.olaore.learning_dagger.screens.activities.BaseActivity
import dev.olaore.learning_dagger.screens.common.dialogs.DialogsNavigator
import dev.olaore.learning_dagger.screens.common.dialogs.ServerErrorDialogFragment
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListViewMvc
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("UNCHECKED_CAST")
class QuestionsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.layout_frame, QuestionsListFragment())
                .commit()
        }

    }

}
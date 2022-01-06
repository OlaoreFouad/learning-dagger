package dev.olaore.learning_dagger.screens.questionslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.olaore.learning_dagger.Constants
import dev.olaore.learning_dagger.MyApplication
import dev.olaore.learning_dagger.models.Result
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.questions.Question
import dev.olaore.learning_dagger.screens.activities.BaseActivity
import dev.olaore.learning_dagger.screens.common.dialogs.DialogsNavigator
import dev.olaore.learning_dagger.screens.common.dialogs.ServerErrorDialogFragment
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator
import dev.olaore.learning_dagger.screens.common.viewmvcs.ViewMvcFactory
import dev.olaore.learning_dagger.screens.fragments.BaseFragment
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListViewMvc
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@AndroidEntryPoint
class QuestionsListFragment : BaseFragment(), QuestionsListViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var isDataLoaded = false

    private lateinit var viewMvc: QuestionsListViewMvc

    @Inject
    lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase

    @Inject
    lateinit var dialogsNavigator: DialogsNavigator

    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewMvc = viewMvcFactory.newQuestionListViewMvc(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    private fun fetchQuestions() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                when (val result = fetchQuestionsUseCase.fetchLatestQuestions()) {
                    is Result.Success<*> -> {
                        viewMvc.bindQuestions(result.data as List<Question>)
                        isDataLoaded = true
                    }
                    is Result.Failure -> {
                        onFetchFailed()
                    }
                }
            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }

    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickedQuestion: Question) {
        screensNavigator.toQuestionDetails(clickedQuestion.id)
    }

    override fun onViewModelButtonClicked() {
        screensNavigator.toViewModel()
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }

}
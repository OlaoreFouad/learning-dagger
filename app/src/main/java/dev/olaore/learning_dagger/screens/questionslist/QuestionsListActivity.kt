package dev.olaore.learning_dagger.screens.questionslist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dev.olaore.learning_dagger.Constants
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.questions.Question
import dev.olaore.learning_dagger.screens.common.dialogs.ServerErrorDialogFragment
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListViewMvc
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionsListActivity : AppCompatActivity(), QuestionsListViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private lateinit var stackoverflowApi: StackoverflowApi
    private var isDataLoaded = false

    private val viewMvc = QuestionsListViewMvc(
        LayoutInflater.from(this), null
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewMvc.rootView)

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        stackoverflowApi = retrofit.create(StackoverflowApi::class.java)
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
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    viewMvc.bindQuestions(response.body()!!.questions)
                    isDataLoaded = true
                } else {
                    onFetchFailed()
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    onFetchFailed()
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
        QuestionDetailsActivity.start(this, clickedQuestion.id)
    }

    private fun onFetchFailed() {
        supportFragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss()
    }

}
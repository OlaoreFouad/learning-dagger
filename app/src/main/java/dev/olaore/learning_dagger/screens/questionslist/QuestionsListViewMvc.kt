package dev.olaore.learning_dagger.screens.questionslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dev.olaore.learning_dagger.R
import dev.olaore.learning_dagger.questions.Question
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import java.util.ArrayList

class QuestionsListViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
) {

    interface Listener {
        fun onRefreshClicked()
        fun onQuestionClicked(clickedQuestion: Question)
    }

    private var swipeRefresh: SwipeRefreshLayout
    private var recyclerView: RecyclerView
    private var questionsAdapter: QuestionsAdapter

    var rootView: View = layoutInflater.inflate(
        R.layout.layout_questions_list, parent, false
    )

    private var listeners = HashSet<Listener>()
    private val context: Context
        get() = rootView.context

    init {

        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.setOnRefreshListener {
            listeners.forEach {
                it.onRefreshClicked()
            }
        }

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        questionsAdapter = QuestionsAdapter { clickedQuestion ->
            listeners.forEach {
                it.onQuestionClicked(clickedQuestion)
            }
        }
        recyclerView.adapter = questionsAdapter

    }

    private fun <T: View> findViewById(@IdRes viewId: Int): T {
        return rootView.findViewById(viewId)
    }

    fun registerListener(listener: Listener) {
        this.listeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        this.listeners.remove(listener)
    }

    fun bindQuestions(questions: List<Question>) {
        this.questionsAdapter.bindData(questions)
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }

    class QuestionsAdapter(
        private val onQuestionClickListener: (Question) -> Unit
    ) : RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder>() {

        private var questionsList: List<Question> = ArrayList(0)

        inner class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.txt_title)
        }

        fun bindData(questions: List<Question>) {
            questionsList = ArrayList(questions)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_question_list_item, parent, false)
            return QuestionViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
            holder.title.text = questionsList[position].title
            holder.itemView.setOnClickListener {
                onQuestionClickListener.invoke(questionsList[position])
            }
        }

        override fun getItemCount(): Int {
            return questionsList.size
        }

    }

}
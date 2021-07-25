package dev.olaore.learning_dagger.screens.questiondetails

import android.content.Context
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dev.olaore.learning_dagger.R
import dev.olaore.learning_dagger.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
) {

    interface Listener {
        fun onToolbarNavigateUp()
    }

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView

    val rootView: View = layoutInflater.inflate(
        R.layout.layout_question_details, parent, false
    )
    private val context: Context
        get() = rootView.context

    private val listeners = HashSet<Listener>()

    init {
        toolbar = findViewById(R.id.toolbar)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        txtQuestionBody = findViewById(R.id.txt_question_body)

        toolbar.setNavigateUpListener {
            listeners.forEach { it.onToolbarNavigateUp()  }
        }

        swipeRefresh.isEnabled = false

    }

    fun registerListener(listener: Listener) {
        this.listeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        this.listeners.remove(listener)
    }

    fun setQuestionText(text: Spanned) {
        txtQuestionBody.text = text
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

    private fun <T: View> findViewById(@IdRes viewId: Int): T {
        return rootView.findViewById(viewId)
    }

}
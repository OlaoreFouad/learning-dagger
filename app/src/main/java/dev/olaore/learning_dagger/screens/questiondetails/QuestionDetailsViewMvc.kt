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
import dev.olaore.learning_dagger.screens.common.viewmvcs.BaseViewMvc

class QuestionDetailsViewMvc(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
    layoutInflater, parent, R.layout.layout_question_details
) {

    interface Listener {
        fun onToolbarNavigateUp()
    }

    private var toolbar: MyToolbar = findViewById(R.id.toolbar)
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView

    init {
        swipeRefresh = findViewById(R.id.swipeRefresh)
        txtQuestionBody = findViewById(R.id.txt_question_body)

        toolbar.setNavigateUpListener {
            listeners.forEach { it.onToolbarNavigateUp()  }
        }

        swipeRefresh.isEnabled = false

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

}
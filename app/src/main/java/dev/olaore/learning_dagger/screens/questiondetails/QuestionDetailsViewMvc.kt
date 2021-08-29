package dev.olaore.learning_dagger.screens.questiondetails

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dev.olaore.learning_dagger.R
import dev.olaore.learning_dagger.imageloader.ImageLoader
import dev.olaore.learning_dagger.questions.QuestionWithBody
import dev.olaore.learning_dagger.screens.common.toolbar.MyToolbar
import dev.olaore.learning_dagger.screens.common.viewmvcs.BaseViewMvc

class QuestionDetailsViewMvc(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    private val imageLoader: ImageLoader
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
    layoutInflater, parent, R.layout.layout_question_details
) {

    interface Listener {
        fun onToolbarNavigateUp()
    }

    private var toolbar: MyToolbar = findViewById(R.id.toolbar)
    private var swipeRefresh: SwipeRefreshLayout = findViewById(R.id.swipeRefresh)
    private var txtQuestionBody: TextView = findViewById(R.id.txt_question_body)
    private var txtUsername: TextView = findViewById(R.id.txt_username)
    private var imgUser: ImageView = findViewById(R.id.img_user)

    init {

        toolbar.setNavigateUpListener {
            listeners.forEach { it.onToolbarNavigateUp() }
        }

        swipeRefresh.isEnabled = false

    }

    fun setQuestion(question: QuestionWithBody) {
        val text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(
                question.body,
                Html.FROM_HTML_MODE_LEGACY
            )
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(
                question.body
            )
        }
        txtQuestionBody.text = text

        txtUsername.text = question.owner.name
        imageLoader.loadImage(question.owner.imageUrl, imgUser)
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

}
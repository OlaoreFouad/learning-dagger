package dev.olaore.learning_dagger.screens.common.viewmvcs

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.olaore.learning_dagger.imageloader.ImageLoader
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsViewMvc
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject
import javax.inject.Provider

class ViewMvcFactory @Inject
constructor(
    private val layoutInflaterProvider: Provider<LayoutInflater>,
    private val imageLoaderProvider: Provider<ImageLoader>
) {

    fun newQuestionListViewMvc(container: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflaterProvider.get(), container)
    }

    fun newQuestionDetailsViewMvc(container: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(
            layoutInflaterProvider.get(),
            container,
            imageLoaderProvider.get()
        )
    }

}
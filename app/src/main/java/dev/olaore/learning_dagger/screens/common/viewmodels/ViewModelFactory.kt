package dev.olaore.learning_dagger.screens.common.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.screens.viewmodels.MyViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject
constructor(
    private val fetchQuestionsUseCase: Provider<FetchQuestionsUseCase>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MyViewModel::class.java -> MyViewModel(fetchQuestionsUseCase.get())
            else -> throw IllegalArgumentException("You cannot create ViewModel for class: ${ modelClass.simpleName }")
        } as T
    }

}
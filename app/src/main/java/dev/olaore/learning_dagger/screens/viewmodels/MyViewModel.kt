package dev.olaore.learning_dagger.screens.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.olaore.learning_dagger.models.Result
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.questions.Question
import dev.olaore.learning_dagger.questionsList
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

class MyViewModel @Inject
constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase
) : ViewModel() {

    private var _questions = MutableLiveData<questionsList>()
    val questions: LiveData<questionsList> get() = _questions

    init {

        viewModelScope.launch {
            val qs = fetchQuestionsUseCase.fetchLatestQuestions()
            if (qs is Result.Success<*>) {
                _questions.postValue(qs.data as questionsList)
            } else {
                throw RuntimeException("Error Occurred, Yo!")
            }
        }

    }

}
package dev.olaore.learning_dagger.screens.viewmodels

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.olaore.learning_dagger.models.Result
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.questions.Question
import dev.olaore.learning_dagger.questionsList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class MyViewModel @Inject
constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _questions : MutableLiveData<questionsList> = savedStateHandle.getLiveData("questions")
    val questions: LiveData<questionsList> get() = _questions

    init {
        viewModelScope.launch {
            delay(5000)
            val qs = fetchQuestionsUseCase.fetchLatestQuestions()
            if (qs is Result.Success<*>) {
                _questions.postValue(qs.data as questionsList)
            } else {
                throw RuntimeException("Error Occurred, Yo!")
            }
        }

    }

}
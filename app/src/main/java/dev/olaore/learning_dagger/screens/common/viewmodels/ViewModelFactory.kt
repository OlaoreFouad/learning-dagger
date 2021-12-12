package dev.olaore.learning_dagger.screens.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.screens.viewmodels.MyViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject
constructor(
    private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
    private val savedStateRegistryOwner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when (modelClass) {

            MyViewModel::class.java -> {
                MyViewModel(fetchQuestionsUseCaseProvider.get(), handle) as T
            }
            else -> throw IllegalArgumentException("You cannot create ViewModel for class: ${ modelClass.simpleName }")

        }
    }

}
package dev.olaore.learning_dagger.common.di.presentation

import androidx.savedstate.SavedStateRegistryOwner
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val savedStateRegistryOwner: SavedStateRegistryOwner) {

    @Provides
    fun provideSavedStateRegistryOwner() = savedStateRegistryOwner

}
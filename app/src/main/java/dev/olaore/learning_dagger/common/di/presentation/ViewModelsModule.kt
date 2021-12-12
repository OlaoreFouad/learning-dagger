package dev.olaore.learning_dagger.common.di.presentation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.olaore.learning_dagger.screens.viewmodels.MyViewModel

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(
        myViewModel: MyViewModel
    ): ViewModel

}
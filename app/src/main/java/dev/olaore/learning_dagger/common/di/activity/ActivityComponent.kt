package dev.olaore.learning_dagger.common.di.activity

import dagger.Subcomponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent

@ActivityScope
@Subcomponent(
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

}
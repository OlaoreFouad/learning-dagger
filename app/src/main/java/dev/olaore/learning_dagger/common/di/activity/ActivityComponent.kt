package dev.olaore.learning_dagger.common.di.activity

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent

@ActivityScope
@Subcomponent(
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun activityModule(module: ActivityModule): Builder

        fun build(): ActivityComponent

    }

}
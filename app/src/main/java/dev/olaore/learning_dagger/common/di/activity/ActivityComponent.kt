package dev.olaore.learning_dagger.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Component
import dagger.Subcomponent
import dev.olaore.learning_dagger.common.di.app.AppComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent
import dev.olaore.learning_dagger.common.di.presentation.PresentationModule
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator

@ActivityScope
@Subcomponent(
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun newPresentationComponent(
        module: PresentationModule
    ): PresentationComponent

}
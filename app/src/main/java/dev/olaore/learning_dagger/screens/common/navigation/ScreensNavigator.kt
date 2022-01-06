package dev.olaore.learning_dagger.screens.common.navigation

interface ScreensNavigator {

    fun navigateBack()

    fun toQuestionDetails(id: String)

    fun toViewModel()

}
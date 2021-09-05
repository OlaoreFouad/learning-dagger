package dev.olaore.learning_dagger.networking

import dev.olaore.learning_dagger.Constants
import javax.inject.Inject

class UrlProvider @Inject constructor() {

    val baseUrl: String
        get() = Constants.BASE_URL

    val otherBaseUrl: String
        get() = "other_base_url"

}
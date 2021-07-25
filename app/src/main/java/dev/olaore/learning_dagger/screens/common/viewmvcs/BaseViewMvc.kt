package dev.olaore.learning_dagger.screens.common.viewmvcs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListViewMvc

open class BaseViewMvc<L>(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?,
    @LayoutRes private val layoutId: Int
) {

    protected val rootView: View = layoutInflater.inflate(
        layoutId, parent, false
    )
    protected val context: Context
        get() = rootView.context

    protected val listeners = HashSet<L>()

    fun registerListener(listener: L) {
        this.listeners.add(listener)
    }

    fun unregisterListener(listener: L) {
        this.listeners.remove(listener)
    }

    protected fun <T: View> findViewById(@IdRes viewId: Int): T {
        return rootView.findViewById(viewId)
    }

}
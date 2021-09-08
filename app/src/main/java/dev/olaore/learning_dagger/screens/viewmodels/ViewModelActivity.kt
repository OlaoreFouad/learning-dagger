package dev.olaore.learning_dagger.screens.viewmodels

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.lifecycle.Observer
import dev.olaore.learning_dagger.R
import dev.olaore.learning_dagger.screens.activities.BaseActivity
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject
    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        myViewModel.questions.observe(this, Observer {
            Toast.makeText(this, "Size of items: ${ it.size }", Toast.LENGTH_LONG).show()
        })

    }

    companion object {
        fun start(context: Context) {
            val viewModelIntent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(viewModelIntent)
        }
    }

}
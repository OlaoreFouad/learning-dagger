package dev.olaore.learning_dagger.screens.viewmodels

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import dev.olaore.learning_dagger.R
import dev.olaore.learning_dagger.screens.activities.BaseActivity

@AndroidEntryPoint
class ViewModelActivity : BaseActivity() {

    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        myViewModel.questions.observe(this, Observer {
            Toast.makeText(this, "Size of items: ${ it.size }", Toast.LENGTH_LONG).show()
        })

    }

    companion object {
        fun start(context: Context) {
            val viewModelIntent = Intent(context, ViewModelActivity::class.java)
            viewModelIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(viewModelIntent)
        }
    }

}
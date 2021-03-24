package com.suman.dagger_hilt.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suman.dagger_hilt.Adapter.PostAdapter
import com.suman.dagger_hilt.Model.Post
import com.codingwithjks.dagger_hilt.R
import com.facebook.stetho.Stetho
import com.suman.dagger_hilt.ViewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var postAdapter: PostAdapter

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Stetho.initializeWithDefaults(this)

        setContentView(R.layout.activity_main)
        setUi()
        setBi()
        setSum()
        postViewModel.getPost()

        postViewModel.postLiveData.observe(this, Observer { response ->
            postAdapter.setData(response as ArrayList<Post>)
        })
    }

    private fun setUi() {
        recyclerView = findViewById(R.id.recyclerView)

        postAdapter = PostAdapter(this, ArrayList())

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }

    private fun setBi() {

    }
    private fun setSum() {

    }

}
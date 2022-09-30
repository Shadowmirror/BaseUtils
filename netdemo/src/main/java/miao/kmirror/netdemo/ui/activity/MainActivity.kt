package miao.kmirror.netdemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import miao.kmirror.library.ui.BaseActivity
import miao.kmirror.netdemo.adapter.ArticleAdapter
import miao.kmirror.netdemo.databinding.ActivityMainBinding
import miao.kmirror.netdemo.viewmodel.ArticleViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mViewModel by viewModels<ArticleViewModel>()

    private val articleAdapter by lazy {
        ArticleAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = binding.recyclerView
        val progressBar = binding.progressBar
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = articleAdapter
        lifecycleScope.launch {
            mViewModel.getPagingData().collect {
                articleAdapter.submitData(it)
            }
        }

        articleAdapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    progressBar.visibility = View.INVISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                is LoadState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.INVISIBLE
                }
                is LoadState.Error -> {
                    val state = it.refresh as LoadState.Error
                    progressBar.visibility = View.INVISIBLE
                    Log.i("miao", "Load Error: ${state.error.message} ")
                    Toast.makeText(
                        this,
                        "Load Error: ${state.error.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}
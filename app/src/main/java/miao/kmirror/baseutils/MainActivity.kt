package miao.kmirror.baseutils

import android.os.Bundle
import android.view.LayoutInflater
import miao.kmirror.baseutils.databinding.ActivityMainBinding
import miao.kmirror.library.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}
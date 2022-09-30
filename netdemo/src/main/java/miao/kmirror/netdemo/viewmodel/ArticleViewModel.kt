package miao.kmirror.netdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import miao.kmirror.netdemo.model.bean.Article
import miao.kmirror.netdemo.model.repository.Repository

class ArticleViewModel : ViewModel() {
    fun getPagingData(): Flow<PagingData<Article>> {
        return Repository.getPagingData().cachedIn(viewModelScope)
    }
}
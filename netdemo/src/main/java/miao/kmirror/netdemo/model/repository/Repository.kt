package miao.kmirror.netdemo.model.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import miao.kmirror.netdemo.https.TestRetrofitClient
import miao.kmirror.netdemo.model.bean.Article
import miao.kmirror.netdemo.ui.paging.RepoPagingSource

object Repository {
    private const val PAGE_SIZE = 20

    private val apiService = TestRetrofitClient.service
    fun getPagingData(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { RepoPagingSource(apiService) }
        ).flow
    }
}
package miao.kmirror.netdemo.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import miao.kmirror.netdemo.https.ApiService
import miao.kmirror.netdemo.model.bean.Article

class RepoPagingSource(private val apiService: ApiService) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val repoResponse = apiService.getArticlesList(page)
            val repoItems = repoResponse.data.datas
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
package miao.kmirror.netdemo.https

import miao.kmirror.netdemo.model.bean.Article
import miao.kmirror.netdemo.model.bean.PageEntity
import miao.kmirror.netdemo.model.bean.Result
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("article/list/{page}/json")
    suspend fun getArticlesList(@Path("page") page: Int = 0): Result<PageEntity<Article>>
}
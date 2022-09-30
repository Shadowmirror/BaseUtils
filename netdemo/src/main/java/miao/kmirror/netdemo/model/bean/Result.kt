package miao.kmirror.netdemo.model.bean

data class Result<T>(
    val code: Int,
    val errorMsg: String?,
    val data: T
)

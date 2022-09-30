package miao.kmirror.netdemo.model.bean

import com.google.gson.annotations.SerializedName

class Article(
    @SerializedName("desc")
    val desc: String,
    val id: Int,
    val title: String,
)
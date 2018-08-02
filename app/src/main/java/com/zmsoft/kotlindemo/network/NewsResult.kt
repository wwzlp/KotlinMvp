package com.zmsoft.kotlindemo.network

import com.zmsoft.kotlindemo.model.Article

class NewsResult {
    var status: String = ""
    var totalResults: Int = 0
    var articles: List<Article>? = null
}
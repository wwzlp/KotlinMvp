package com.zmsoft.kotlindemo.model

/**
 * 文章
 */
class Article {
    //来源
    var source: Source? = null
    //作者
    var author: String = ""
    //标题
    var title: String = ""
    //简介
    var description: String = ""
    //新闻详情地址
    var url: String = ""
    //图片地址
    var urlToImage: String = ""
    //发布时间
    var publishedAt: String = ""
}
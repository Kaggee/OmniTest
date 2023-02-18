package com.example.omnitest.model

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */

@Xml(name = "rss")
data class NewsWrapper (
    @Element(name = "channel")
    val newsModel: NewsModel,

    @Attribute
    val version: String
)

@Xml(name = "channel")
data class NewsModel (
    @Element(name = "item")
    var itemList: List<NewsItem> = listOf()
)

@Xml(name = "item")
data class NewsItem(
    @PropertyElement(name = "title")
    var newsTitle: String = "",

    @PropertyElement(name = "description")
    val newsDescription: String = "",

    @PropertyElement(name = "pubDate")
    val publishDate: String = "",

    @PropertyElement(name = "link")
    val newsLink: String = "",

    @Element(name = "media:thumbnail")
    val newsImage: Media? = null
)

@Xml(name = "media:thumbnail")
data class Media(
    @Attribute(name = "url")
    var url: String = ""
)
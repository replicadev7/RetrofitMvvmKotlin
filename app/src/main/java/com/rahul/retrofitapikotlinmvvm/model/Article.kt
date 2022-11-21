package com.rahul.retrofitapikotlinmvvm.model

data class Article(
   public val author: String,
   public val content: String,
   public val description: String,
   public val publishedAt: String,
   public val source: Source,
   public val title: String,
   public val url: String,
   public val urlToImage: String
)
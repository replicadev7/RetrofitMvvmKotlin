package com.rahul.retrofitapikotlinmvvm.model

data class MainModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
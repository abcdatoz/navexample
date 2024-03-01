package com.example.navexample.data.remote.network

import com.example.navexample.data.remote.model.BookModel
import com.example.navexample.util.Constants.Companion.BOOKS_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {
    @GET(BOOKS_ENDPOINT)
    suspend fun getBooks(): Response<BookModel>
}
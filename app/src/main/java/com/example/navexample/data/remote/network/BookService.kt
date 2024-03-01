package com.example.navexample.data.remote.network

import com.example.navexample.data.remote.model.BookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookService @Inject constructor(private val bookApi: BookApi) {

    suspend fun getBooks(): BookModel {
        return withContext(Dispatchers.IO){
            val books = bookApi.getBooks()

            books.body()!!
        }
    }
}
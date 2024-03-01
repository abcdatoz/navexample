package com.example.navexample.repo

import com.example.navexample.data.remote.model.BookModel
import com.example.navexample.data.remote.network.BookService
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookService: BookService) {
    suspend fun getBooks(): BookModel {
        return bookService.getBooks()
    }
}
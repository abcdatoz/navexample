package com.example.navexample.domain

import com.example.navexample.data.remote.model.BookModel
import com.example.navexample.repo.BookRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(private val bookRepository: BookRepository) {

    suspend operator fun invoke(): BookModel{
        return bookRepository.getBooks()
    }
}
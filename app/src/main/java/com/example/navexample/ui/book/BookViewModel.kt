package com.example.navexample.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navexample.data.remote.model.BookModel
import com.example.navexample.data.remote.model.Data
import com.example.navexample.domain.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class BookViewModel @Inject constructor (private val getBooksUseCase: GetBooksUseCase): ViewModel(){

    val initialState = BookModel(emptyList<Data>())

    private val _books = MutableStateFlow(initialState)
    val books: StateFlow<BookModel> get() = _books


    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch{
            try{
                val books = getBooksUseCase()

                println(books)
                _books.value = books

            }catch(_: Exception){}
        }
    }


}
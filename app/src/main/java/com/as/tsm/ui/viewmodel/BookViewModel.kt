package com.`as`.tsm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.`as`.tsm.data.BookRepository
import com.`as`.tsm.data.model.Book

class BookViewModel : ViewModel(){
    private val repository = BookRepository()

    private val _bookList = MutableLiveData<List<Book>>()
    val bookList: LiveData<List<Book>> = _bookList

    init{
        _bookList.value = repository.getAllBooks()
    }

    private fun deleteBook(book: Book){
        val newList = repository.bookList
        newList.remove(book)

        _bookList.value = newList.toList()
    }
}
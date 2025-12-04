package com.`as`.tsm.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.`as`.tsm.data.BookRepository
import com.`as`.tsm.data.local.BookLocalDataSource
import com.`as`.tsm.data.local.database.AppDatabase
import com.`as`.tsm.data.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val bookDao = AppDatabase.getInstance(application).bookDao()
    private val localDataSource = BookLocalDataSource(bookDao)
    private val repository = BookRepository(localDataSource)

    private val _booklist = repository.getAllBooks().asLiveData()

    val bookList: LiveData<List<Book>> = _booklist

    init {
        repository.getAllBooks()
    }

    fun removeBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repository.remove(book)
    }

    fun addBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repository.add(book)
    }

    fun readBook(bookId: Int, isRead: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        repository.readBook(bookId, isRead)
    }
}
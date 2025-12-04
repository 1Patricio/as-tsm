package com.`as`.tsm.data.local

import com.`as`.tsm.data.local.dao.BookDao
import com.`as`.tsm.data.local.entities.BookEntity
import kotlinx.coroutines.flow.Flow

class BookLocalDataSource (private val bookDao: BookDao) {
    fun getAllBooks(): Flow<List<BookEntity>> = bookDao.getAllBooks()

    suspend fun addBook(book: BookEntity) {
        bookDao.insert(book)
    }

    suspend fun deleteBook(book: BookEntity) {
        bookDao.delete(book)
    }

    suspend fun readBook(bookId: Int, isRead: Boolean) {
        bookDao.readBook(bookId, !isRead)
    }
}
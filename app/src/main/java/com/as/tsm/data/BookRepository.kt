package com.`as`.tsm.data

import com.`as`.tsm.data.local.BookLocalDataSource
import com.`as`.tsm.data.local.entities.BookEntity
import com.`as`.tsm.data.mappers.convertToEntity
import com.`as`.tsm.data.mappers.convertToModel
import com.`as`.tsm.data.model.Book
import kotlinx.coroutines.flow.map

class BookRepository(private val dataSource: BookLocalDataSource) {
    fun getAllBooks() =
        dataSource.getAllBooks().map { entities -> entities.map { it.convertToModel() } }

    suspend fun remove(book: Book) = dataSource.deleteBook(book.convertToEntity())
    suspend fun add(book: Book) = dataSource.addBook(book.convertToEntity())
    suspend fun readBook(bookId: Int, isRead: Boolean) = dataSource.readBook(bookId, isRead)
    suspend fun editBook(bookEditado: BookEntity) =dataSource.editBook(bookEditado)
}

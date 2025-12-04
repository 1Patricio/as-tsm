package com.`as`.tsm.data.mappers

import com.`as`.tsm.data.local.entities.BookEntity
import com.`as`.tsm.data.model.Book

fun Book.convertToEntity() =
    BookEntity(
        title = this.title,
        author = this.author,
        yearPublication = this.yearPublication,
        synopsis = this.synopsis,
        read = this.read,
    )

fun BookEntity.convertToModel() =
    Book(
        id = this.id,
        title = this.title,
        author = this.author,
        yearPublication = this.yearPublication,
        synopsis = this.synopsis,
        read = this.read
    )
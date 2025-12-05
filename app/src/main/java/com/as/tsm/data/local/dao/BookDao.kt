package com.`as`.tsm.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.`as`.tsm.data.local.entities.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: BookEntity)

    @Query("SELECT * FROM books")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("Update books SET read = :isRead where id = :bookId")
    suspend fun readBook(bookId: Int, isRead: Boolean)

    @Update
    suspend fun editBook(vararg book: BookEntity): Int

    @Delete
    fun delete(book: BookEntity)
}
package com.`as`.tsm.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.`as`.tsm.R
import com.`as`.tsm.data.model.Book

class BookViewHolder (
    bookView : View,
    private val onDelete: (Book) -> Unit,
    private val onDetails: (Book) -> Unit
) : RecyclerView.ViewHolder(bookView){
    private val bookTitle: TextView = bookView.findViewById(R.id.bookTitle)
    private val bookAuthor: TextView = bookView.findViewById(R.id.bookAuthor)
}
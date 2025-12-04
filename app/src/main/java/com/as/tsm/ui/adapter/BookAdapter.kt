package com.`as`.tsm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.`as`.tsm.R
import com.`as`.tsm.data.model.Book

class BookAdapter(
    private val onDelete: (Book) -> Unit,
    private val onDetails: (Book) -> Unit
) : ListAdapter<Book, BookViewHolder>(BookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val bookView =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item_list, parent, false)
        return BookViewHolder(bookView = bookView, onDelete = onDelete, onDetails = onDetails)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
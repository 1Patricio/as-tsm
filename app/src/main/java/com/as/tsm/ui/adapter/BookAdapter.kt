package com.`as`.tsm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.`as`.tsm.data.model.Book
import com.`as`.tsm.databinding.BookItemListBinding

class BookAdapter(
    private val onDelete: (Book) -> Unit,
    private val onDetails: (Book) -> Unit,
    private val onCheck: (Book) -> Unit,
    private val onEdit: (Book) -> Unit
) : ListAdapter<Book, BookViewHolder>(BookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding =
            BookItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(
            binding = binding,
            onDelete = onDelete,
            onDetails = onDetails,
            onCheck = onCheck,
            onEdit = onEdit
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
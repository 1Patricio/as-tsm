package com.`as`.tsm.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.`as`.tsm.data.model.Book
import com.`as`.tsm.databinding.BookItemListBinding

class BookViewHolder (
    private val binding: BookItemListBinding,
    private val onDelete: (Book) -> Unit,
    private val onDetails: (Book) -> Unit,
    private val onCheck: (Book) -> Unit,
    private val onEdit: (Book) -> Unit,

) : RecyclerView.ViewHolder(binding.root){
    fun bind(book: Book) {
        binding.book = book

        binding.actionDelete.setOnLongClickListener {
            onDelete(book)
            true
        }

        binding.actionDetails.setOnClickListener {
            onDetails(book)
        }

        binding.actionEdit.setOnClickListener {
            onEdit(book)
        }

        binding.readCheck.addOnCheckedStateChangedListener { check, _ ->
            val newBook = book.copy(read = check.isChecked)
            binding.book = newBook
            onCheck(newBook)
        }
    }
}
package com.`as`.tsm.ui.adapter

import android.view.ViewGroup
import com.`as`.tsm.data.model.Book

class BookAdapter {
    private val onDelete: (Book) -> Unit,
    private val onDetails: (Book) -> Unit
    ) : ListAdapter<Todo, TodoViewHolder>(TodoDiffCallback()) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.todo_item_list, parent, false)
            return TodoViewHolder(itemView = itemView, onDelete = onDelete, onDetails = onDetails)
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            holder.bind(getItem(position))
        }
}
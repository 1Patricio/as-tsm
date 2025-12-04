package com.`as`.tsm.ui.adapter

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.`as`.tsm.R
import com.`as`.tsm.data.model.Book
import com.google.android.material.checkbox.MaterialCheckBox

class BookViewHolder (
    bookView : View,
    private val onDelete: (Book) -> Unit,
    private val onDetails: (Book) -> Unit
) : RecyclerView.ViewHolder(bookView){
    private val bookTitle: TextView = bookView.findViewById(R.id.bookTitle)
    private val bookAuthor: TextView = bookView.findViewById(R.id.bookAuthor)
    private val yearPublication: TextView = itemView.findViewById(R.id.yearPublication)
    private val synopsis: TextView = itemView.findViewById(R.id.bookSynopsis)
    private val read: MaterialCheckBox = itemView.findViewById(R.id.readCheck)
    private val actionDelete: TextView = itemView.findViewById(R.id.actionDelete)
    private val actionDetails: TextView = itemView.findViewById(R.id.actionDetails)

    fun bind(book: Book) {
        bookTitle.text = book.title
        bookAuthor.text = book.author
        read.isChecked = book.read
        yearPublication.text = book.yearPublication.toString()
        synopsis.text = book.synopsis

        actionDelete.setOnClickListener {
            onDelete(book)
        }

        actionDetails.setOnClickListener {
            onDetails(book)
        }
        doPaintTask()
        paintTaskChecked()
    }

    private fun paintTaskChecked() {
        this.read.addOnCheckedStateChangedListener { checkBox, state ->
            if (checkBox.isChecked) {
                this.bookTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.bookAuthor.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.yearPublication.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.synopsis.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.actionDetails.visibility = View.GONE
                this.actionDelete.visibility = View.GONE
            } else {
                this.bookTitle.paintFlags = 0
                this.bookAuthor.paintFlags = 0
                this.yearPublication.paintFlags = 0
                this.synopsis.paintFlags = 0
                this.actionDetails.visibility = View.VISIBLE
                this.actionDelete.visibility = View.VISIBLE
            }
        }
    }

    private fun doPaintTask() {
        if (this.read.isChecked) {
            this.bookTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            this.bookAuthor.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            this.yearPublication.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            this.synopsis.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            this.actionDetails.visibility = View.GONE
            this.actionDelete.visibility = View.GONE
        } else {
            this.bookTitle.paintFlags = 0
            this.bookAuthor.paintFlags = 0
            this.yearPublication.paintFlags = 0
            this.synopsis.paintFlags = 0
            this.actionDetails.visibility = View.VISIBLE
            this.actionDelete.visibility = View.VISIBLE
        }
    }
}
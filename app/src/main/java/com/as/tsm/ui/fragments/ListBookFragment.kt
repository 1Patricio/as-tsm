package com.`as`.tsm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.`as`.tsm.R
import com.`as`.tsm.ui.adapter.BookAdapter
import com.`as`.tsm.ui.viewmodel.BookViewModel

class ListBookFragment : Fragment() {
    private lateinit var adapter: BookAdapter
    private val bookViewModel: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rc = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = BookAdapter(
            onDelete = { book ->
                deleteBook(view = view, recyclerview = rc, book = book)
            },
            onDetails = { book ->
                goToDetails(book = book)
            }
        )
        rc.adapter = adapter

        bookViewModel.bookList.observe(viewLifecycleOwner){ todo ->
            adapter.submitList(todo)
        }
    }
}
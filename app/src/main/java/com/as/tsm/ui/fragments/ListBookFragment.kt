package com.`as`.tsm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.`as`.tsm.R
import com.`as`.tsm.data.BookRepository
import com.`as`.tsm.data.model.Book
import com.`as`.tsm.ui.adapter.BookAdapter
import com.`as`.tsm.ui.viewmodel.BookViewModel
import com.google.android.material.snackbar.Snackbar
import kotlin.getValue

class ListBookFragment : Fragment() {
    private lateinit var adapter: BookAdapter
    private lateinit var binding: ListBookFragmentBiding

    private val bookViewModel: BookViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        savedInstanceState: Bundle?
    ): View? {
        bookViewModel.bookList.observe(viewLifecycleOwner) { book ->
            adapter.submitList(book.toMutableList())
        }

        binding = ListBookFragment.inflate(inflater, container, false)

        return inflater.inflate(R.layout.fragment_list_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        adapter = BookAdapter(
            onDelete = { book ->
                Snackbar.make(
                    view.context,
                    recyclerView,
                    "Deletado com sucesso!",
                    Snackbar.LENGTH_SHORT
                ).show()

                val newList = bookRepository.bookList.toMutableList()
                newList.remove(book)

                bookRepository.bookList = newList
                adapter.submitList(newList)
            },
            onDetails = { book ->
                val action =
                    ListBookFragmentDirections.actionListBookFragmentToDetailsBookFragment(book)

                findNavController().navigate(action)
            }
        )

        recyclerView.adapter = adapter
        adapter.submitList(bookRepository.bookList)
    }
}
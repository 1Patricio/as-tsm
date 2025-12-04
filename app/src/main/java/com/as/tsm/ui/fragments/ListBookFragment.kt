package com.`as`.tsm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.`as`.tsm.R
import com.`as`.tsm.data.model.Book
import com.`as`.tsm.databinding.FragmentListBookBinding
import com.`as`.tsm.ui.adapter.BookAdapter
import com.`as`.tsm.ui.viewmodel.BookViewModel
import com.google.android.material.snackbar.Snackbar
import kotlin.getValue
import kotlin.io.root

class ListBookFragment : Fragment() {
    private lateinit var binding: FragmentListBookBinding
    private lateinit var adapter: BookAdapter
    private val bookViewModel: BookViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookViewModel.bookList.observe(viewLifecycleOwner) { book ->
            adapter.submitList(book.toMutableList())
        }

        binding = FragmentListBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rc = binding.recyclerView
        adapter = BookAdapter(
            onDelete = { book ->
                bookViewModel.removeBook(book)
            },
            onDetails = { book ->
                goToDetails(book = book)
            },
            onCheck = { book ->
                bookViewModel.readBook(bookId = book.id, isRead = !book.r)
            }
        )
        rc.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val action = ListBookFragmentDirections.actionListTodoFragmentToFormTodoFragment()
            findNavController().navigate(action)
        }
    }

    private fun goToDetails(book: Book) {
        val action = ListBookFragmentDirections.actionListBookFragmentToDetailsBookFragment(book)
        findNavController().navigate(action)
    }

}
package com.`as`.tsm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.`as`.tsm.data.model.Book
import com.`as`.tsm.databinding.FragmentFormBookBinding
import com.`as`.tsm.ui.viewmodel.BookViewModel

class FormBookFragment : Fragment() {
    private lateinit var binding: FragmentFormBookBinding
    private val bookViewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val book = Book(
                title = binding.txvTitle.text.toString(),
                taskDescription = binding.txvDescription.text.toString(),
                openedBy = binding.txvUser.text.toString()
            )

            bookViewModel.addBook(book)
            val action = FormBookFragmentDirections.actionFormBookFragmentToListBookFragment()
            findNavController().navigate(action)
        }
    }
}
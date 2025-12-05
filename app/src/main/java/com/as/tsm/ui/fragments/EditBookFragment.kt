package com.`as`.tsm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.`as`.tsm.data.local.entities.BookEntity
import com.`as`.tsm.databinding.FragmentEditBookBinding
import com.`as`.tsm.ui.viewmodel.BookViewModel
import kotlin.getValue

class EditBookFragment : Fragment(){
    private val args: EditBookFragmentArgs by navArgs()
    private lateinit var binding: FragmentEditBookBinding
    private val bookViewModel: BookViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val originalBook = args.book

        binding.txvTitle.setText(originalBook.title)
        binding.txvSynopsis.setText(originalBook.synopsis)
        binding.txvAuthor.setText(originalBook.author)
        binding.txvYearPublication.setText(originalBook.yearPublication)

        binding.editButton.setOnClickListener {
            val updatedBook = BookEntity(
                id = originalBook.id,
                title = binding.txvTitle.text.toString(),
                synopsis = binding.txvSynopsis.text.toString(),
                author = binding.txvAuthor.text.toString(),
                yearPublication = binding.txvYearPublication.text.toString()
            )

            bookViewModel.editBook(updatedBook)
            findNavController().popBackStack()
        }
    }
}
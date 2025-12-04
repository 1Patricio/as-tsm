package com.`as`.tsm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.`as`.tsm.R
import com.`as`.tsm.databinding.FragmentDetailsBookBinding

class DetailsBookFragment : Fragment() {
    private  lateinit var binding: FragmentDetailsBookBinding
    val args: DetailsBookFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val book = args.book

        view.findViewById<TextView>(R.id.idBook).text = book.id.toString()
        view.findViewById<TextView>(R.id.fragmentBookTitle).text = book.title
        view.findViewById<TextView>(R.id.fragmentAuthor).text = book.author
        view.findViewById<TextView>(R.id.fragmentYearPublication).text = book.yearPublication.toString()
        view.findViewById<TextView>(R.id.fragmentSynopsis).text = book.synopsis
    }
}
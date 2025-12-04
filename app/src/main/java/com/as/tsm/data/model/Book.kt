package com.`as`.tsm.data.model

import java.io.Serializable

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val yearPublication: Int,
    val synopsis: String,
    val read: Boolean
) : Serializable


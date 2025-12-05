package com.`as`.tsm.data.model

import java.io.Serializable

data class Book(
    val id: Int = 0,
    val title: String = "",
    val author: String = "",
    val yearPublication: String = "22/03/2003",
    val synopsis: String = "",
    val read: Boolean = false
) : Serializable


package com.osovan.serendipityapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nook(
    val id: Int,
    val name: String,
    val cover: String,
    val description: String,
    val location: String,
    val rating: Float
): Parcelable
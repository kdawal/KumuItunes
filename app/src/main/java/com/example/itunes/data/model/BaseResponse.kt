package com.example.itunes.data.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    val resultCount: Int? = null,
    val results: T? = null
)
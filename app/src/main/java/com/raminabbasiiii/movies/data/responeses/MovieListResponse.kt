package com.raminabbasiiii.movies.data.responeses

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("data")
    val data: List<MovieDto>,

    @SerializedName("metadata")
    val metaData: MetaData
    )
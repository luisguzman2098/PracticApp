package com.luisguzman.myapplication1.data.api

import com.luisguzman.myapplication1.domain.model.Entries
import com.luisguzman.myapplication1.utils.Response
import retrofit2.http.GET

interface ApiService {

    @GET("entries")
    suspend fun getEntries() : Response<List<Entries>>

}
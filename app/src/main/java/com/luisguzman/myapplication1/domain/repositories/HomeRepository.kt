package com.luisguzman.myapplication1.domain.repositories

import com.luisguzman.myapplication1.domain.model.Entries
import com.luisguzman.myapplication1.utils.Response

interface HomeRepository {

    suspend fun getEntries() : Response<List<Entries>>
}
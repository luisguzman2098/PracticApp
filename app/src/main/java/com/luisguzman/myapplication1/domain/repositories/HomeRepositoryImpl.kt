package com.luisguzman.myapplication1.domain.repositories

import com.luisguzman.myapplication1.data.api.ApiService
import com.luisguzman.myapplication1.domain.model.Entries
import com.luisguzman.myapplication1.utils.Response
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : HomeRepository {
    override suspend fun getEntries(): Response<List<Entries>> {
        return apiService.getEntries()
    }
}
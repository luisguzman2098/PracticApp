package com.luisguzman.myapplication1.data.di

import com.luisguzman.myapplication1.data.api.ApiService
import com.luisguzman.myapplication1.domain.repositories.HomeRepository
import com.luisguzman.myapplication1.domain.repositories.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.publicapis.org/")
            .build()
    }

    @Singleton
    @Provides
    fun provideHomeRepository(apiService: ApiService) : HomeRepository = HomeRepositoryImpl(apiService)
}
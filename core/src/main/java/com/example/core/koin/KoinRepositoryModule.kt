package com.example.core.koin

import com.example.core.network.NetworkRepository
import com.example.core.repository.IndexRepository
import com.example.core.repository.indexRepositoryImpl.IndexRepositoryImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val repositoryModule = module {
    single<IndexRepository> { IndexRepositoryImpl(get()) }
}

val retrofitModule = module {


    fun provideNetworkRepository() : NetworkRepository {


        val retrofit = Retrofit.Builder()
            .baseUrl("http://tomaszgadek.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        // Create Retrofit client
        return retrofit.create(NetworkRepository::class.java)
    }

    single { provideNetworkRepository() }

}
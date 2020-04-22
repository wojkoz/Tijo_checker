package com.example.core.koin

import com.example.core.mapper.MapIndexDetailsToDto
import com.example.core.mapper.MapListToDto
import com.example.core.network.NetworkRepository
import com.example.core.repository.IndexRepository
import com.example.core.repository.indexRepositoryImpl.IndexRepositoryImpl
import com.example.core.responseHandler.ResponseHandler
import com.example.core.responseHandler.responseHandlerImpl.ResponseHandlerImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val repositoryModule = module {
    single<IndexRepository> {  IndexRepositoryImpl(networkRepository = get(), itemMapper =  MapIndexDetailsToDto(), listMapper =  MapListToDto(), responseHandler = get()) }
    single<ResponseHandler> {ResponseHandlerImpl()}
}

val retrofitModule = module {


    fun provideNetworkRepository() : NetworkRepository {


        val retrofit = Retrofit.Builder()
            .baseUrl("http://tomaszgadek.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(NetworkRepository::class.java)
    }

    single { provideNetworkRepository() }

}
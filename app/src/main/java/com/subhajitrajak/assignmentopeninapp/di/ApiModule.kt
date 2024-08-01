package com.subhajitrajak.assignmentopeninapp.di

import android.content.Context
import com.subhajitrajak.assignmentopeninapp.api.ApiService
import com.subhajitrajak.assignmentopeninapp.api.AuthInterceptor
import com.subhajitrajak.assignmentopeninapp.utils.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providePrefManager(@ApplicationContext context: Context): PreferenceManager {
        return PreferenceManager(context)
    }

    @Provides
    @Singleton
    fun provideOkHTTPClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient, prefManager: PreferenceManager): ApiService {
        return Retrofit.Builder()
            .baseUrl(prefManager.getBaseUrl()!!)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}
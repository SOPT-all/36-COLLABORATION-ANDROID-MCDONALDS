package org.sopt.mcdonalds.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import org.sopt.mcdonalds.BuildConfig
import org.sopt.mcdonalds.BuildConfig.BASE_URL
import org.sopt.mcdonalds.core.network.AuthInterceptor
import org.sopt.mcdonalds.core.network.isJsonArray
import org.sopt.mcdonalds.core.network.isJsonObject
import retrofit2.Converter
import retrofit2.Retrofit
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val APPLICATION_JSON = "application/json"

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    @Provides
    @Singleton
    fun provideJsonConverter(json: Json): Converter.Factory =
        json.asConverterFactory(APPLICATION_JSON.toMediaType())

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor { message ->
        when {
            message.isJsonObject() ->
                Timber.tag("okhttp").d(JSONObject(message).toString(4))

            message.isJsonArray() ->
                Timber.tag("okhttp").d(JSONObject(message).toString(4))

            else -> {
                Timber.tag("okhttp").d("CONNECTION INFO -> $message")
            }
        }
    }.apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @JWT
    @Provides
    @Singleton
    fun provideJWTHttpLoggingInterceptor(authInterceptor: AuthInterceptor): Interceptor =
        authInterceptor

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @JWT
    @Provides
    @Singleton
    fun provideJWTOkHttpClient(
        loggingInterceptor: Interceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        factory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(factory)
        .build()

    @JWT
    @Provides
    fun provideJWTRetrofit(
        @JWT client: OkHttpClient,
        factory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(factory)
        .build()
}

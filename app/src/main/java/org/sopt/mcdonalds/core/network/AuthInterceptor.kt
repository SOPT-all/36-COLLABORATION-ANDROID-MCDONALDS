package org.sopt.mcdonalds.core.network

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import org.sopt.mcdonalds.core.local.TokenDataStore
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenDataStore: TokenDataStore,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val accessToken = runBlocking { tokenDataStore.getAccessToken() }

        val authenticatedRequest = originalRequest.newBuilder().apply {
            if (!accessToken.isNullOrBlank()) {
                header("userId", accessToken)
            }
        }.build()

        return chain.proceed(authenticatedRequest)
    }
}
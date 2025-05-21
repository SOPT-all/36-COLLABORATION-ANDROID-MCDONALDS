package org.sopt.mcdonalds.data.cart.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import org.sopt.mcdonalds.data.cart.repository.CartRepositoryImpl
import org.sopt.mcdonalds.domain.cart.repository.CartRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCartRepository(
        cartRepositoryImpl: CartRepositoryImpl,
    ): CartRepository
}
package org.sopt.mcdonalds.data.menu.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.mcdonalds.data.menu.repository.MenuRepositoryImpl
import org.sopt.mcdonalds.domain.menu.repository.MenuRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMenuRepository(
        menuRepositoryImpl: MenuRepositoryImpl,
    ): MenuRepository
}

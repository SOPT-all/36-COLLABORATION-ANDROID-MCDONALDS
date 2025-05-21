package org.sopt.mcdonalds.data.menu.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.mcdonalds.data.menu.service.MenuService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideMenuService(retrofit: Retrofit): MenuService =
        retrofit.create()
}

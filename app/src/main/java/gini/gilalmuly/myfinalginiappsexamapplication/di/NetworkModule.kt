package gini.gilalmuly.myfinalginiappsexamapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gini.gilalmuly.myfinalginiappsexamapplication.data.network.ApiService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideUnsplashService(): ApiService {
        return ApiService.create()
    }
}
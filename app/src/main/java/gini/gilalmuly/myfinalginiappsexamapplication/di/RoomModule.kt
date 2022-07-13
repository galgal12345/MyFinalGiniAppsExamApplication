package gini.gilalmuly.myfinalginiappsexamapplication.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gini.gilalmuly.myfinalginiappsexamapplication.data.db.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideWhetherDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, AppDatabase::class.java, "table_data").build()


    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.getDataDao()
}
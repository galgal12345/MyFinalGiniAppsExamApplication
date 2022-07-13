package gini.gilalmuly.myfinalginiappsexamapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gini.gilalmuly.myfinalginiappsexamapplication.data.db.entities.Data


@Database(entities = [Data::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDataDao():WhetherDao
}
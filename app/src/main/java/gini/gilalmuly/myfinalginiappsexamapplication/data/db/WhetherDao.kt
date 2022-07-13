package gini.gilalmuly.myfinalginiappsexamapplication.data.db

import androidx.room.*
import gini.gilalmuly.myfinalginiappsexamapplication.data.db.entities.Data
import kotlinx.coroutines.flow.Flow

@Dao
interface WhetherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: Data)

    @Delete
    suspend fun deleteData(data: Data)

    @Query("SELECT * FROM table_data ")
    fun getAllData(): Flow<Data>
}
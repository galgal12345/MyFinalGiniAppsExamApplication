package gini.gilalmuly.myfinalginiappsexamapplication.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Entity(tableName = "table_data")
@Parcelize
data class Data (
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val lat: Int,
    val lng: Int,
    val summary: String,
    val icon: String,
    val temperature: String,
    ): Parcelable
package gini.gilalmuly.myfinalginiappsexamapplication.data.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Whether(
    @SerializedName("data")
    @Expose
    val data: Data,
    @SerializedName("message")
    @Expose
    val message: String
)
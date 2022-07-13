package gini.gilalmuly.myfinalginiappsexamapplication.data.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Data(
    @SerializedName("apparentTemperature")
    @Expose
    val apparentTemperature: Double,
    @SerializedName("cloudCover")
    @Expose
    val cloudCover: Int,
    @SerializedName("dewPoint")
    @Expose
    val dewPoint: Double,
    @SerializedName("humidity")
    @Expose
    val humidity: Double,
    @SerializedName("icon")
    @Expose
    val icon: String,
    @SerializedName("lat")
    @Expose
    val lat: Int,
    @SerializedName("lng")
    @Expose
    val lng: Int,
    @SerializedName("ozone")
    @Expose
    val ozone: Double,
    @SerializedName("precipIntensity")
    @Expose
    val precipIntensity: Int,
    @SerializedName("pressure")
    @Expose
    val pressure: Double,
    @SerializedName("summary")
    @Expose
    val summary: String,
    @SerializedName("temperature")
    @Expose
    val temperature: Double,
    @SerializedName("time")
    @Expose
    val time: Int,
    @SerializedName("uvIndex")
    @Expose
    val uvIndex: Double,
    @SerializedName("visibility")
    @Expose
    val visibility: Double,
    @SerializedName("windBearing")
    @Expose
    val windBearing: Double,
    @SerializedName("windGust")
    @Expose
    val windGust: Double,
    @SerializedName("windSpeed")
    @Expose
    val windSpeed: Double
)
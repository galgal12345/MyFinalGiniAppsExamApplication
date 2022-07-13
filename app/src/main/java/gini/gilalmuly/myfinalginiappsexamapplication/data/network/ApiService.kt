package gini.gilalmuly.myfinalginiappsexamapplication.data.network

import gini.gilalmuly.myfinalginiappsexamapplication.BuildConfig
import gini.gilalmuly.myfinalginiappsexamapplication.data.models.Whether
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather/latest/by-lat-lng")
    suspend fun searchWeather(@Query("lat") lat: Long, @Query("lng") lng: Long, @Query("x-api-key") apikey: String = BuildConfig.WHETHER_API_KEY): Whether

        companion object {
            private const val BASE_URL = BuildConfig.WHETHER_API_URL

            fun create(): ApiService {
                val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

                val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()

                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
        }
}
package gini.gilalmuly.myfinalginiappsexamapplication.data.models

import gini.gilalmuly.myfinalginiappsexamapplication.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(private val service: ApiService) {
    suspend fun fetchAllWeather() = withContext(Dispatchers.IO) {
        service.searchWeather(12, 77)
    }

}
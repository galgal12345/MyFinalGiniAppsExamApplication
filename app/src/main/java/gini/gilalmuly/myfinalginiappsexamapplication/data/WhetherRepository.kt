package gini.gilalmuly.myfinalginiappsexamapplication.data

import gini.gilalmuly.myfinalginiappsexamapplication.data.db.WhetherDao
import gini.gilalmuly.myfinalginiappsexamapplication.data.db.entities.Data
import gini.gilalmuly.myfinalginiappsexamapplication.data.models.WeatherRemoteDataSource
import gini.gilalmuly.myfinalginiappsexamapplication.data.models.Whether
import gini.gilalmuly.myfinalginiappsexamapplication.data.network.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class WhetherRepository @Inject constructor(
    private val service: ApiService,
    private val whetherDao: WhetherDao,
    private val weatherRDS: WeatherRemoteDataSource,
) {

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

    private var myWeatherFlow = flow {
        emit(weatherRDS.fetchAllWeather())
    }

    val weatherFlow: Flow<Data>
        get() = whetherDao.getAllData().flowOn(defaultDispatcher).conflate()

    suspend fun insertRun(data: Data) = whetherDao.insertData(data)

    suspend fun delete(data: Data) = whetherDao.deleteData(data)

    suspend fun getWhether(lat: Long = 12, lng: Long = 77): Whether {
        return service.searchWeather(lat, lng)
    }

}
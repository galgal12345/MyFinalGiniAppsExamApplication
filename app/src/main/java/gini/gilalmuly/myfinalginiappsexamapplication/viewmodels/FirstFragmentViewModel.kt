package gini.gilalmuly.myfinalginiappsexamapplication.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gini.gilalmuly.myfinalginiappsexamapplication.data.WhetherRepository
import gini.gilalmuly.myfinalginiappsexamapplication.data.db.entities.Data
import gini.gilalmuly.myfinalginiappsexamapplication.data.models.Whether
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@ObsoleteCoroutinesApi
@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val repository: WhetherRepository
) : ViewModel() {

    private val TAG = "FirstFragmentViewModel"

    private val _whether = MutableStateFlow<Whether?>(null)
    var whether = _whether.asStateFlow()


    //todo problem with state flow
    fun getVMWhether() {
        viewModelScope.launch {
            repository.getWhether()
            Log.d(TAG,"this is what comes from repo get whether method:" + repository.getWhether())
        }
    }

    //--------------------------------

    private val myChannel = ConflatedBroadcastChannel<Data>()
    val myFlow: Flow<Data> = myChannel.asFlow()








}
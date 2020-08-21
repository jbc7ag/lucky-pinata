package com.jbc7ag.luckypinata.myadvice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jbc7ag.luckypinata.network.AdviceApi
import com.jbc7ag.luckypinata.network.AdviceProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception


enum class AdviceStatus { ERROR, LOADING, DONE }

class MyAdviceViewModel : ViewModel(){



    private var _properties = MutableLiveData<AdviceProperty>()
    val properties: LiveData<AdviceProperty>
        get() = _properties

    private var _status = MutableLiveData<AdviceStatus>()
    val status: LiveData<AdviceStatus>
        get() = _status

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope( viewModelJob + Dispatchers.Main )



    init{
        getAdviceProperty()
    }

    private fun getAdviceProperty(){

        coroutineScope.launch {

            _status.value = AdviceStatus.LOADING
            var getProperty = AdviceApi.retrofitService.getProperty()

            try {
                var property = getProperty.await()
                _properties.value =  property
                _status.value = AdviceStatus.DONE

            }catch (e: Exception){
                Timber.i("EROR ${e}");
                _status.value = AdviceStatus.ERROR
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
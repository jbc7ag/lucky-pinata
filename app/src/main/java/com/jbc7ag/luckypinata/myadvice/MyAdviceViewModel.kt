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

            var getProperty = AdviceApi.retrofitService.getProperty()

            try {
                var property = getProperty.await()
                _properties.value =  property

            }catch (e: Exception){
                Timber.i("EROR ${e}");
            }
        }

       /* getProperty.enqueue(object : Callback<AdviceProperty> {
            override fun onResponse(call: Call<AdviceProperty>, response: Response<AdviceProperty>) {
                if (response.code() == 200) {
                    _properties.value = response.body()
                    Timber.i("result "+ _properties.value);

                }
            }

            override fun onFailure(call: Call<AdviceProperty>, t: Throwable) {
               // _properties.value = t.message
                Timber.i("error")
            }
        }) */

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
package com.jbc7ag.luckypinata.myadvice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jbc7ag.luckypinata.network.AdviceApi
import com.jbc7ag.luckypinata.network.AdviceProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


enum class AdviceStatus { ERROR, LOADING, DONE }

class MyAdviceViewModel : ViewModel(){



    private var _properties = MutableLiveData<AdviceProperty>()
    val properties: LiveData<AdviceProperty>
        get() = _properties

    init{
        getAdviceProperty()
    }

    private fun getAdviceProperty(){

        var getProperty = AdviceApi.retrofitService.getProperty()

        getProperty.enqueue(object : Callback<AdviceProperty> {
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
        })

    }

}
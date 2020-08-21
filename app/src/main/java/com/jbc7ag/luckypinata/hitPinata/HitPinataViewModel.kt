package com.jbc7ag.luckypinata.hitPinata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import kotlin.random.Random

class HitPinataViewModel() : ViewModel() {

    private var _randomNumber: Int = 0

    private var _countClick = MutableLiveData<Int>()
    val countClick : LiveData<Int>
        get() = _countClick

    private var _finishHit = MutableLiveData<Boolean>()
    val finishHit : LiveData<Boolean>
        get() = _finishHit

    init {
        initValues()
    }

    fun addClick(){
        _countClick.value = _countClick.value?.plus(1);

        if(_countClick.value == _randomNumber){
            Timber.i(" Add clicks : ${countClick.value}")
            _finishHit.value = true
            initValues()
        }

    }

    fun initValues(){
        _countClick.value = 0;
        _randomNumber = Random.nextInt(5, 10)
        _finishHit.value = false
    }

}
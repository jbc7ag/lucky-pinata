package com.jbc7ag.luckypinata.hitPinata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class HitPinataViewModel() : ViewModel() {

    private var _randomNumber = MutableLiveData<Int>()
    val randomNumber : LiveData<Int>
        get() = _randomNumber

    private var _countClick = MutableLiveData<Int>()
    val countClick : LiveData<Int>
        get() = _countClick

    private var _finishHit = MutableLiveData<Boolean>()
    val finishHit : LiveData<Boolean>
        get() = _finishHit

    init{
        initValues()
    }

    fun finishHits(): Boolean{
       if(_countClick.value == _randomNumber.value){
           _finishHit.value = true
           initValues()
           return true

       }
        _finishHit.value = false
        return false

    }

    fun addClick(){
        _countClick.value = _countClick.value?.plus(1);
    }

    fun initValues(){
        _countClick.value = 0;
        _randomNumber.value = Random.nextInt(5, 10)
    }

}
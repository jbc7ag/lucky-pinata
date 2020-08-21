package com.jbc7ag.luckypinata

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jbc7ag.luckypinata.myadvice.AdviceStatus


@BindingAdapter("status")
fun bindStatus(txtAdvice: TextView, status: AdviceStatus?){
    when(status){
        AdviceStatus.LOADING ->{
            txtAdvice.text = txtAdvice.getResources().getString(R.string.text_status_loading)
        }
        AdviceStatus.ERROR ->{
            txtAdvice.text = txtAdvice.getResources().getString(R.string.text_status_error)
        }
    }
}

@BindingAdapter("statuslod")
fun bindStatusImg(statusImageView: ImageView, status: AdviceStatus?){
    when(status){
        AdviceStatus.LOADING ->{
            statusImageView.visibility = View.VISIBLE
        }
        else -> {
            statusImageView.visibility = View.GONE
        }
    }
}
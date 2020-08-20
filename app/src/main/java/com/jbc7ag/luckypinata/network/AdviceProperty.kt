package com.jbc7ag.luckypinata.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AdviceProperty(
    val slip: AdviceData
    ): Parcelable

@Parcelize
data class AdviceData (
    val id: Int,
    val advice: String
): Parcelable
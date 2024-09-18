package com.example.fastcalculation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameResult(
    var hits: Int = 0,
    var totalGameTime: Long = 0L
) : Parcelable

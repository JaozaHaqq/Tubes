package com.example.tubes_pbb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    var image : Int = 0,
    var title : String,
    var desc : String
) : Parcelable
package com.sirketismi.kasimturkcellandroid3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(var title : String, var name : String, var description : String) : Parcelable {
}
package com.alvin.uts_18090121.utils

import java.text.NumberFormat
import java.util.*

object Uang {
    fun indonesia(uang: Double) : String {
        val localeId = Locale("in", "ID")
        val kursId : NumberFormat = NumberFormat.getCurrencyInstance(localeId)

        return kursId.format(uang)
    }
}
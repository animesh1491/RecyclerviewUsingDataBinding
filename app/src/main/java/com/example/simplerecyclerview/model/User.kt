package com.example.simplerecyclerview.model

import java.math.BigDecimal
import java.text.Format
import java.text.NumberFormat
import java.util.*

class User(val userName: String, val userAge: Int, val userSalary: Double) {

    fun getUserSalary(): String? {
        val format: Format = NumberFormat.getCurrencyInstance(Locale("en", "in"))
        return format.format(BigDecimal(userSalary))
    }

    fun getUserAge() : String = userAge.toString()

}
package com.andres.parcial_segundocorte

import java.io.Serializable

data class Product(val code: String, val productName: String, val price: String, val discount: String) :
    Serializable
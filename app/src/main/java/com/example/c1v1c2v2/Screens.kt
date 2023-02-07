package com.example.c1v1c2v2

sealed class Screens(val route: String){
    object Dilution: Screens("dilution_screen")
    object Stock: Screens("stock_screen")
}

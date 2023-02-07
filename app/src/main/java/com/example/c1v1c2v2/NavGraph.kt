package com.example.c1v1c2v2

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.Dilution.route){
        composable(route = Screens.Dilution.route){ ValueInputs(navController = navController)}
        composable(route = Screens.Stock.route){ StockCreation(navController = navController)}
    }
}
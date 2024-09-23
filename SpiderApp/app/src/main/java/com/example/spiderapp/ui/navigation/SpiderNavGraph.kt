package com.example.spiderapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spiderapp.ui.SpiderScreen
import com.example.spiderapp.ui.SpiderViewModel
import com.example.spiderapp.ui.SpiderViewModelFactory
import com.example.spiderapp.data.SpiderRepository
import com.example.spiderapp.ui.SplashScreen

@Composable
fun SpiderNavGraph(navController: NavHostController, spiderRepository: SpiderRepository) {
    val viewModel: SpiderViewModel = viewModel(factory = SpiderViewModelFactory(spiderRepository))

    NavHost(navController, startDestination = "splashScreen") {
        composable("splashScreen") { SplashScreen(navController) }
        composable("spiderScreen") { SpiderScreen(viewModel) }
    }
}

package com.example.spiderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.spiderapp.data.AppContainer
import com.example.spiderapp.ui.navigation.SpiderNavGraph
import com.example.spiderapp.ui.theme.SpiderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpiderAppTheme {

                val appContainer = AppContainer(applicationContext)
                val spiderRepository = appContainer.spiderRepository
                val navController = rememberNavController()
                SpiderNavGraph(navController = navController, spiderRepository = spiderRepository)
            }
        }
    }
}

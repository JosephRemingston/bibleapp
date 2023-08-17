package com.example.bible_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFA6DCE0))){
                screen()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainpg(){
    var navcontroller = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navController = navcontroller) }) {
        Box(Modifier.padding(it)) {
            NavHost(navController = navcontroller, startDestination = btn.route) {
                composable(menu.route) {
                    MenuScreen()
                }
                composable(btn.route) {
                    screen()
                }
                composable(ai.route) {
                    LocationScreen()
                }
            }
        }
    }
}

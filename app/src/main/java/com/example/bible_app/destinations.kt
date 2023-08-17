package com.example.bible_app

interface Destinations {
    val route: String
    val icon: Int
    val title: String
}


object menu : Destinations {
    override val route = "Menu"
    override val icon = R.drawable.menu
    override val title = "Menu"
}


object btn : Destinations {
    override val route = "btn"
    override val icon = R.drawable.btn
    override val title = "btn"
}


object ai : Destinations {
    override val route = "Location"
    override val icon = R.drawable.ai
    override val title = "Location"
}
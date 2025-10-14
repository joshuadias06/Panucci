package br.com.alura.panucci.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import androidx.navigation.navOptions
import br.com.alura.panucci.navigation.drinkListRoute
import br.com.alura.panucci.navigation.drinkListScreen
import br.com.alura.panucci.navigation.highlightListRoute
import br.com.alura.panucci.navigation.highlightListScreen
import br.com.alura.panucci.navigation.menuListRoute
import br.com.alura.panucci.navigation.menuListScreen
import br.com.alura.panucci.navigation.navigateToDrinkList
import br.com.alura.panucci.navigation.navigateToHighlightsList
import br.com.alura.panucci.navigation.navigateToMenuList
import br.com.alura.panucci.ui.components.BottomAppBarItem

internal const val homeGraphRoute = "home"

fun NavGraphBuilder.homGraph(navController: NavHostController) {
    navigation(startDestination = highlightListRoute, route = homeGraphRoute) {
        highlightListScreen(navController)
        menuListScreen(navController)
        drinkListScreen(navController)
    }
}

fun NavController.navigateToHomeGraph(){
    navigate(homeGraphRoute)
}

fun NavController.navigateSingleTopWithPopUpTo(
    item: BottomAppBarItem
) {
    val (route, navigate) = when (item) {
        BottomAppBarItem.DrinkList -> Pair(
            drinkListRoute,
            ::navigateToDrinkList
        )

        BottomAppBarItem.HighlightList -> Pair(
            highlightListRoute,
            ::navigateToHighlightsList
        )

        BottomAppBarItem.MenuList -> Pair(
            menuListRoute,
            ::navigateToMenuList
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }
    navigate(navOptions)
}
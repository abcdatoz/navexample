package com.example.navexample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navexample.ui.bnmx.About.AvisoPrivacidad
import com.example.navexample.ui.bnmx.About.Faq
import com.example.navexample.ui.bnmx.About.OperacionesDisponibles
import com.example.navexample.ui.bnmx.About.TerminosYCondiciones
import com.example.navexample.ui.bnmx.AcercaDe
import com.example.navexample.ui.bnmx.SignIn
import com.example.navexample.ui.bnmx.WelcomeLogo
import com.example.navexample.ui.bnmx.WelcomeMenu
import com.example.navexample.ui.bnmx.WelcomeName

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.WelcomeName.route) {

        composable(route = AppScreens.WelcomeName.route) {
            WelcomeName(navController)
        }

        composable(
            route = AppScreens.WelcomeLogo.route + "/{text}", arguments = listOf(
                navArgument(name = "text") {
                    type = NavType.StringType
                })
        ) {
            WelcomeLogo(navController, it.arguments?.getString("text"))
        }

        composable(
            route = AppScreens.WelcomeMenu.route
        ){
            WelcomeMenu(navController)
        }

        composable (
            route = AppScreens.SignIn.route
        ){
            SignIn(navController)
        }

        composable (
            route = AppScreens.AcercaDe.route
        ){
            AcercaDe(navController)
        }

        composable (route = AppScreens.OperacionesDisponibles.route){
            OperacionesDisponibles(navController)
        }

        composable(route = AppScreens.Faq.route){
            Faq(navController)
        }

        composable (route = AppScreens.TerminosYCondiciones.route){
            TerminosYCondiciones(navController)
        }

        composable(route = AppScreens.AvisoPrivacidad.route){
            AvisoPrivacidad(navController)
        }

    }

}

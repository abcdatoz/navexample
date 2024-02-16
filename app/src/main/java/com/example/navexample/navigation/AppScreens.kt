package com.example.navexample.navigation

import androidx.compose.runtime.Composable

sealed class AppScreens (val route: String){
    object WelcomeName: AppScreens("welcome_name")
    object WelcomeLogo: AppScreens("welcome_logo")
    object WelcomeMenu: AppScreens("welcome_menu")
    object SignIn: AppScreens("sign_in")
    object AcercaDe: AppScreens("about_us")
    object OperacionesDisponibles: AppScreens("operaciones_disponibles")
    object Faq: AppScreens("faq")
    object TerminosYCondiciones :AppScreens("terminos_y_condiciones")
    object AvisoPrivacidad:AppScreens("aviso_privacidad")
}




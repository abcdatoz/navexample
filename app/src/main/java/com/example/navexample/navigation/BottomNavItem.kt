package com.example.navexample.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.navexample.R

sealed class BottomNavItem(
    var title:  String,
    var icon: ImageVector
){

    object Home: BottomNavItem("Home", Icons.Rounded.Home)
    object List: BottomNavItem("List", Icons.Rounded.List)
    object Analytics: BottomNavItem("Analytcis", Icons.Rounded.CheckCircle)
    object Profile: BottomNavItem("Profile", Icons.Rounded.AccountBox)

}

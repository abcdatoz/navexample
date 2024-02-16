package com.example.navexample.ui.bnmx

import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navexample.R


sealed class BottomNavigationScreens(
    val route: String, @StringRes val resourceId: Int, val icon: ImageVector
) {
    object Frankendroid :
        BottomNavigationScreens("Frankendroid", R.string.frankendroid_route, Icons.Rounded.Home)

    object Pumpkin :
        BottomNavigationScreens("Pumpkin", R.string.pumpkin_route, Icons.Rounded.CheckCircle)

    object Ghost : BottomNavigationScreens("Ghost", R.string.ghost_route, Icons.Rounded.ArrowBack)
    object ScaryBag :
        BottomNavigationScreens("ScaryBag", R.string.scary_bag_route, Icons.Rounded.Build)
}

sealed class ScaryAnimation(val animId: Int) {
    object Frankendroid : ScaryAnimation(R.drawable.android)
    object Pumpkin : ScaryAnimation(R.drawable.python)
    object Ghost : ScaryAnimation(R.drawable.javascript)
    object ScaryBag : ScaryAnimation(R.drawable.node)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Submenu() {

    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Frankendroid,
        BottomNavigationScreens.Pumpkin,
        BottomNavigationScreens.Ghost,
        BottomNavigationScreens.ScaryBag
    )

    Scaffold(bottomBar = {
        SpookyAppBottomNavigation(navController, bottomNavigationItems)
    }) {


        Column(modifier = Modifier.padding(top = 57.dp)) {
            MainScreenNavigationConfigurations(navController)
        }


    }


}

@Composable
private fun MainScreenNavigationConfigurations(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationScreens.Frankendroid.route) {

        composable(BottomNavigationScreens.Frankendroid.route) {
            ScaryScreen(ScaryAnimation.Frankendroid)
        }

        composable(BottomNavigationScreens.Pumpkin.route) {
            ScaryScreen(ScaryAnimation.Pumpkin)
        }

        composable(BottomNavigationScreens.Ghost.route) {
            ScaryScreen(scaryAnimation = ScaryAnimation.Ghost)
        }

        composable(BottomNavigationScreens.ScaryBag.route) {
            ScaryScreen(scaryAnimation = ScaryAnimation.ScaryBag)
        }
    }
}


@Composable
private fun ScaryScreen(scaryAnimation: ScaryAnimation) {
    val state = remember { mutableSetOf(0) }

    AndroidView(factory = { ctx ->
        ImageView(ctx).apply {
            val drawable = ContextCompat.getDrawable(ctx, scaryAnimation.animId)
            setImageDrawable(drawable)

            layoutParams = ViewGroup.LayoutParams(300, 300)
            scaleType = ImageView.ScaleType.FIT_XY
        }
    })


}

@Composable
private fun SpookyAppBottomNavigation(
    navController: NavHostController, items: List<BottomNavigationScreens>
) {

    NavigationBar {

        val currentRoute = currentRoute(navController)


        items.forEach { screen ->

            //AddItem(screen = screen)

            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        println(screen.route)
                        println("currentroute" + currentRoute)
                        navController.navigate(screen.route)
                    }
                },
                label = { Text(stringResource(id = screen.resourceId)) },
                alwaysShowLabel = currentRoute == screen.route,
                icon = {
                    Icon(
                        screen.icon, contentDescription = "screen."
                    )

                })

        }
    }

}
//
//@Composable
//fun RowScope.AddItem(screen: BottomNavigationScreens) {
//
//    NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = {
//        Icon(
//            screen.icon, contentDescription = "screen."
//        )
//
//    })
//}

@Composable
private fun currentRoute(navController: NavHostController): String? {


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    return currentRoute

}

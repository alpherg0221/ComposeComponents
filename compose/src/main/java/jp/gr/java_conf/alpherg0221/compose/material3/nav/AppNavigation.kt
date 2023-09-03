package jp.gr.java_conf.alpherg0221.compose.material3.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.QuestionMark
import androidx.compose.ui.graphics.vector.ImageVector

data class RouteInfo(
    val icon: ImageVector = Icons.Rounded.QuestionMark,
    val label: String = "",
    val route: String = "",
)

abstract class AppDest {
    val homeRoute: RouteInfo = RouteInfo(
        icon = Icons.Rounded.Home,
        label = "Home",
        route = "home",
    )
}
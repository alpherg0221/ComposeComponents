package jp.gr.java_conf.alpherg0221.compose.material3.component

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import jp.gr.java_conf.alpherg0221.compose.material3.nav.AppDest
import jp.gr.java_conf.alpherg0221.compose.material3.nav.RouteInfo
import kotlinx.coroutines.launch

@Composable
fun <T : AppDest> DrawerApp(
    navController: NavHostController,
    appDest: T,
    drawerItems: List<RouteInfo>,
    gesturesDisabledRoute: List<String> = listOf(),
    builder: NavGraphBuilder.() -> Unit,
) {
    val scope = rememberCoroutineScope()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: appDest.homeRoute.route

    // ドロワーの状態
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // ナビゲーションドロワー
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Drawer(
                currentRoute = currentRoute,
                drawerItems = (listOf(appDest.homeRoute) + drawerItems).map { item ->
                    DrawerItem(
                        icon = item.icon,
                        label = item.label,
                        route = item.route,
                        action = { navController.navigate(item.route) },
                    )
                },
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        },
        gesturesEnabled = currentRoute !in gesturesDisabledRoute,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        NavHost(
            navController = navController,
            startDestination = appDest.homeRoute.route,
            builder = builder,
        )
    }

    // ドロワーが開いているときはバックボタンでドロワーを閉じる
    BackHandler(enabled = drawerState.isOpen) {
        scope.launch { drawerState.close() }
    }
}
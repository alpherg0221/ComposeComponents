package jp.gr.java_conf.alpherg0221.compose.material3.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.QuestionMark
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class DrawerItem(
    val icon: ImageVector = Icons.Rounded.QuestionMark,
    val label: String = "",
    val route: String = "",
    val action: () -> Unit = {}
)

@Composable
fun Drawer(
    currentRoute: String,
    drawerItems: List<DrawerItem>,
    closeDrawer: () -> Unit = {},
) {
    ModalDrawerSheet(modifier = Modifier.statusBarsPadding()) {
        Spacer(Modifier.height(12.dp))
        drawerItems.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    closeDrawer()
                    item.action()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}
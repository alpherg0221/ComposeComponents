package jp.gr.java_conf.alpherg0221.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetLayout(
    modifier: Modifier = Modifier,
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = Modifier.selectableGroup()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(16.dp)
            )
            Row(content = actions)
        }
        AppDivider()
        Column(modifier = modifier, content = content)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CheckboxItem(
    label: String,
    checked: Boolean,
    onChecked: () -> Unit = {},
) {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onChecked() }
                .padding(horizontal = 24.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { onChecked() },
            )
            Text(
                text = label,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RadioButtonItem(
    label: String,
    selected: Boolean,
    onChecked: () -> Unit = {},
) {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onChecked() }
                .padding(horizontal = 24.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected,
                onClick = onChecked,
            )
            Text(
                text = label,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
    }
}
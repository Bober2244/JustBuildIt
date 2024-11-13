package dev.bober.presentation.ui.customer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun EditCustomerMenu(
    isMenuActivated: MutableState<Boolean>,
    offset: DpOffset,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DropdownMenu(
        expanded = isMenuActivated.value,
        onDismissRequest = {
            isMenuActivated.value = false
        },
        offset = offset
    ) {
        DropdownMenuItem(
            text = { Text(text = "Изменить") },
            onClick = {
                isMenuActivated.value = false
                onEditClick()
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                )
            },
            modifier = modifier,
        )
        HorizontalDivider()
        DropdownMenuItem(
            text = { Text(text = "Удалить") },
            onClick = {
                isMenuActivated.value = false
                onDeleteClick()
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                )
            },
        )
    }
}

@Preview(showBackground = true, widthDp = 350, heightDp = 700)
@Composable
private fun EditCustomerMenuPreview() {
    EditCustomerMenu(
        isMenuActivated = remember { mutableStateOf(true) },
        onEditClick = {},
        onDeleteClick = {},
        offset = DpOffset(0.dp, 0.dp)
    )
}
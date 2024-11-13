package dev.bober.presentation.ui.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bober.presentation.entity.Order
import dev.bober.presentation.ui.customer.EditCustomerMenu

@Composable
fun CustomerItem(
    order: Order,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isMenuActivated = rememberSaveable { mutableStateOf(false) }
    var pressOffset by remember { mutableStateOf(DpOffset.Zero) }
    var itemHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
            .onSizeChanged {
                itemHeight = with(density) { it.height.toDp() }
            }
            .pointerInput(true) {
                detectTapGestures(
                    onLongPress = {
                        isMenuActivated.value = true
                        pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                    },
                    onTap = {
                        onClick()
                    }
                )
            }
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = order.customer,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            )
            Spacer(modifier = Modifier.size(size = 6.dp))
            Text(
                text = order.email,
                fontSize = 12.sp,
            )
            Text(text = order.birthday)
        }
        EditCustomerMenu(
            isMenuActivated = isMenuActivated,
            offset = pressOffset.copy(
                y = pressOffset.y - itemHeight
            ),
            onEditClick = {
                //TODO()
            },
            onDeleteClick = {
                //TODO()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomerItemPreview() {
    CustomerItem(
        order = Order(
            customer = "Арутюнян С. В.",
            email = "fwbhkfewfb@gmail.com",
            birthday = "20.08.2004",
            phone = "",
            buildings = listOf(),
        ),
        onClick = {}
    )
}
package dev.bober.presentation.ui.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bober.presentation.entity.Order

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomerItem(
    order: Order,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onLongClick = {/*TODO("")*/ },
                onClick = onClick
            ),
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
            endDate = "",
            startDate = "",
        ),
        onClick = {}
    )
}
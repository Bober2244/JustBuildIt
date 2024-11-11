package dev.bober.presentation.ui.customer

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bober.presentation.entity.Order

@Composable
fun CustomerScreen(
    order: Order,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = order.customer,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(6.dp))
        Text(text = order.birthday)
        Text(text = order.email)
    }
}

@Preview(showBackground = true, widthDp = 350, heightDp = 700)
@Composable
private fun CustomerScreenPreview() {
    CustomerScreen(
        order = Order(
            customer = "Арутюнян С. В.",
            email = "fwbhkfewfb@gmail.com",
            birthday = "20.08.2004",
            phone = "",
            startDate = "",
            endDate = "",
        )
    )
}
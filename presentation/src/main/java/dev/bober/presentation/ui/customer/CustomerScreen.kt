package dev.bober.presentation.ui.customer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bober.presentation.entity.Building
import dev.bober.presentation.entity.Order

@Composable
fun CustomerScreen(
    order: Order,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier.fillMaxWidth().padding(4.dp)
    ) {
        item {
            Text(
                text = order.customer,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = order.email)
            Text(text = order.birthday)
            Spacer(modifier.size(20.dp))
            Text(
                text = "Заявки",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        items(order.buildings) { building ->
            Card(
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.background,
                    disabledContainerColor = MaterialTheme.colorScheme.onBackground,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = cardElevation(
                    defaultElevation = 2.dp,
                    draggedElevation = 8.dp,
                    pressedElevation = 0.dp,
                ),
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = "Заявка на строительство на ${building.constructionPeriod} дней")
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Строительство с ${building.startDate} по ${building.endDate}")
                }

            }
        }
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
            buildings = listOf(
                Building(
                    bidDate = "19.10.2022",
                    constructionPeriod = "180",
                    startDate = "25.10.2022",
                    endDate = "15.04.2023"
                ),
                Building(
                    bidDate = "19.10.2023",
                    constructionPeriod = "365",
                    startDate = "25.10.2022",
                    endDate = "19.9.2024"
                ),
            ),
        )
    )
}
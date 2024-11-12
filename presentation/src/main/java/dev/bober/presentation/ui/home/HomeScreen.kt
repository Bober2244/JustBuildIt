package dev.bober.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bober.presentation.entity.Order
import dev.bober.presentation.ui.core.CustomerItem

@Composable
fun HomeScreen(
    data: MutableList<Order>,
    onItemClick: (order: Order) -> Unit,
    //viewModel: HomeViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val lazyListState = rememberLazyListState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = lazyListState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.imePadding()
        ) {
            items(data) { model ->
                CustomerItem(
                    order = model,
                    onClick = { onItemClick(model) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        data = mutableListOf(
            Order(
                customer = "Арутюнян С. В.",
                email = "fwbhkfewfb@gmail.com",
                birthday = "20.08.2004",
                phone = "",
                buildings = listOf(),
            )
        ),
        onItemClick = {},
    )
}
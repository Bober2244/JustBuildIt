package dev.bober.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.bober.presentation.ui.core.SearchToolbar

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchToolbar(
            searchQuery = "",
            onSearchQueryChanged = {},
            onSearchTriggered = {},
            onBackClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen()
}
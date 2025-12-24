package ui

import Product
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProductsGrid(
    modifier: Modifier = Modifier,
    inputItems: List<Product>,
    onProductClicked: (Product) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
//            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxWidth()
    ) {
        items(inputItems.sortedBy { it.name }) { item ->
            ProductCard(item, onProductClicked = onProductClicked)
        }
    }
}
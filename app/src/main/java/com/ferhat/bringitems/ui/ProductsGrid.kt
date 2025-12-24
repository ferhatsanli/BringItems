package ui

import Product
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ferhat.bringitems.ui.ProductCard


@Composable
fun ProductsGrid(
    modifier: Modifier = Modifier,
    inputItems: List<Product>,
    onProductClicked: (Product) -> Unit = {}
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

@Preview(showBackground = true)
@Composable
fun PreviewProductGrid(){
    var theList = listOf(
        Product.CHOPPED_GARLIC_BOTTLE,
        Product.BUFFALO_MOZZARELLA,
        Product.COCA_COLA_ZERO
    )
    ProductsGrid(inputItems = theList) { }
}
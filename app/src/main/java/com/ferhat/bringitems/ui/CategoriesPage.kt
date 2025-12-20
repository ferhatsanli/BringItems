package com.ferhat.bringitems.ui

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ferhat.bringitems.ProductCategory

@Composable
fun CategoriesPage(
    categoryNames: List<Any>,
    modifier: Modifier = Modifier,
    onCategorySelected: (ProductCategory) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = categoryNames) { item ->
            CategoryCard(item as ProductCategory) {
                onCategorySelected(item)
            }
        }
    }
}

@Composable
fun CategoryCard(
    item: ProductCategory,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Text(
            item.toString().replace('_', ' '),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoriesPage() {
    val theList: List<ProductCategory> = ProductCategory.entries
    CategoriesPage(theList, modifier = Modifier.width(200.dp), {})
}
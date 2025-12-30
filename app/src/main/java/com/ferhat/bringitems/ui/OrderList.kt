package com.ferhat.bringitems.ui

import com.ferhat.bringitems.data.model.CustomerOrders
import com.ferhat.bringitems.data.model.Product
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Refresh


@Composable
// key: Product, value: amount
fun OrderList(theList: CustomerOrders, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    )
    {
        items(
            items = theList.getSortedOrdersList(),
            key = { it.first }
        ) { (prod, amount) ->
            OrderRow(theList, prod, amount, true)
        }
    }
}

@Composable
fun ListOperationsBar(
    modifier: Modifier = Modifier,
    onSaveButtonClicked: () -> Unit = {},
    onLoadButtonClicked: () -> Unit = {},
    onShareButtonClicked: () -> Unit = {},
    onClearButtonClicked: () -> Unit = {}
) {
    Column(modifier = modifier) {
        FlowRow(
//            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            CommonButton(
                icon = Icons.Filled.Edit,
                title = "Save",
                onClick = onSaveButtonClicked,
//                modifier = Modifier.weight(1f)
            )
            CommonButton(
                icon = Icons.Filled.Refresh,
                title = "Load",
                onClick = onLoadButtonClicked,
//                modifier = Modifier.weight(1f)
            )
            CommonButton(
                icon = Icons.AutoMirrored.Filled.Send,
                title = "Share",
                onClick = onShareButtonClicked,
//                modifier = Modifier.weight(1f)
            )
            CommonButton(
                icon = Icons.Filled.Delete,
                title = "Clear",
                onClick = onClearButtonClicked,
//                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewOrderList() {
    val theList = CustomerOrders()
    theList.plus(Product.FANTA_EXOTIC, 3)
    theList.plus(Product.CHICKEN_POPS, 2)
    theList.plus(Product.BUFFALO_SAUCE_BOTTLE, 2)
    theList.plus(Product.CHOPPED_GARLIC_BOTTLE, 1)
    OrderList(theList)
}

@Preview(showBackground = true)
@Composable
fun PreviewListOperationsBar() {
    ListOperationsBar()
}

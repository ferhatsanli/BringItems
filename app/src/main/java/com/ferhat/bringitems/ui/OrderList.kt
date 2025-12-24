package com.ferhat.bringitems.ui

import CustomerOrders
import Product
import android.content.res.Resources
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.vector.ImageVector


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
fun OrderRow(
    theList: CustomerOrders,
    prod: Product,
    amount: Int,
    showDeleteButton: Boolean = true
) {
    val fontSize = 20.sp
    val iconSize = 30.dp
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            // ADD AND MINUS BUTTONS
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            theList.plus(prod, updateRecentOrder = true)
                        },
                    border = BorderStroke(2.dp, Color.Gray)
                ) {
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = "add",
                        tint = Color.Black
                    )
                }
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            theList.minus(prod)
                        },
                    border = BorderStroke(2.dp, Color.Gray)
                ) {
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "subtract",
                        tint = Color.Black
                    )
                }

            }

            // TITLE AND AMOUNT
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
//                    modifier = Modifier.padding(8.dp),
                        text = prod.title,
                        fontSize = fontSize,
                    )
                }
                Text(
//                    modifier = Modifier.padding(8.dp),
                    text = "x$amount",
                    fontSize = fontSize,
                    softWrap = false
                )
            }
            // DELETE BUTTON
            if (showDeleteButton) {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                    CommonButton(
//                        icon = Icons.Default.Close,
//                        onClick = {
//                            theList.minus(prod, amount)
//                        }
//                    )
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
//                        .weight(0f)
                            .clickable {
                                theList.minus(prod, amount)
                            },
                        border = BorderStroke(2.dp, Color.Gray)
                    ) {

                        Icon(
                            modifier = Modifier
                                .size(iconSize)
                                .fillMaxSize(),
                            imageVector = Icons.Default.Close,
                            contentDescription = "remove",
                            tint = Color.Red,
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun ListOperationsBar(
    modifier: Modifier = Modifier,
    onShareButtonClicked: () -> Unit = {},
    onClearButtonClicked: () -> Unit = {}
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            CommonButton(
                icon = Icons.AutoMirrored.Filled.Send,
                title = "Share",
                onClick = onShareButtonClicked
            )
            CommonButton(
                icon = Icons.Filled.Delete,
                title = "Clear",
                onClick = onClearButtonClicked
            )
        }
    }

}

@Composable
fun CommonButton(modifier: Modifier = Modifier,
                 icon: ImageVector,
                 title: String = "",
                 tintColor: Color = Color.Black,
                 backColor: Color = Color.Gray,
                 onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick),
        border = BorderStroke(2.dp, backColor)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title.lowercase(),
                tint = tintColor,
//                modifier = Modifier.size(24.dp)
            )
            if (title.isNotEmpty()) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
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

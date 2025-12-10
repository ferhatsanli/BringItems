package ui

import CustomerOrders
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import to2Digits


@Composable
// key: Product, value: amount
fun OrderList(theList: CustomerOrders, modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(
            items = theList.getOrdersList(),
            key = {it.first}
        ) { (prod, amount) ->
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row {
                    Card (
                      modifier = Modifier
                          .clickable{
                              theList.plus(prod)
                          }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "add",
                            tint = Color.Green
                        )
                    }
                    Card (
                        modifier = Modifier
                            .clickable{
                                theList.minus(prod)
                            }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "subtract",
                            tint = Color.Green
                        )
                    }

                }
                Text(text = prod.title)
                Text(text = "$amount x ${(prod.price*amount).to2Digits()}")
                Card(
                    modifier = Modifier
                        .clickable {
                            theList.minus(prod, amount)
                        }
                ){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "remove",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}
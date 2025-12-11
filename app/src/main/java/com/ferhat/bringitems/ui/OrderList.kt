package ui

import CustomerOrders
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import to2Digits
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.MutableState
import com.ferhat.bringitems.exportTheList
import com.ferhat.bringitems.shareText


@Composable
// key: Product, value: amount
fun OrderList(theList: CustomerOrders, modifier: Modifier = Modifier) {
    val fontSize = 22.sp
    val iconSize = 30.dp
    LazyColumn (
        modifier = modifier
            .fillMaxWidth()
//            .fillMaxHeight()
    )
    {
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
                            modifier = Modifier.size(iconSize),
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
                            modifier = Modifier.size(iconSize),
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "subtract",
                            tint = Color.Green
                        )
                    }

                }
//                Row(horizontalArrangement = Arrangement.SpaceBetween){
//                }
                    Text(text = prod.title, fontSize = fontSize)
                    Text(text = "x$amount", fontSize = fontSize)
                Card(
                    modifier = Modifier
                        .clickable {
                            theList.minus(prod, amount)
                        }
                ){
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = Icons.Default.Close,
                        contentDescription = "remove",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

@Composable
fun ListOperationsBar(modifier: Modifier = Modifier,
                      onShareButtonClicked: () -> Unit = {},
                      onClearButtonClicked: () -> Unit = {}) {
    val fontSize = 20.sp // 16
    val iconSize = 24.dp // 20
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .clickable(onClick = onShareButtonClicked)
            )
            {
                Row(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "share",
                        tint = Color.Yellow,
                        modifier = Modifier.size(iconSize)
                    )
                    Text(
                        text = "Share",
                        fontSize = fontSize,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Card(modifier = Modifier.clickable(onClick = onClearButtonClicked)) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "clear",
                        tint = Color.Yellow,
                        modifier = Modifier.size(iconSize)
                    )
                    Text(
                        text = "Clear",
                        fontSize = fontSize,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewListOperationsBar(){
    ListOperationsBar()
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderList() {
    val theList = CustomerOrders()
    theList.plus(Product.FANTA_EXOTIC, 3)
    theList.plus(Product.CHICKEN_POPS, 2)
    OrderList(theList)
}
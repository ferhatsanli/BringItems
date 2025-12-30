package com.ferhat.bringitems.ui

import com.ferhat.bringitems.data.model.CustomerOrders
import com.ferhat.bringitems.data.model.Product
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_MASK
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CommonButton(modifier: Modifier = Modifier,
                 icon: ImageVector,
                 title: String = "",
                 tintColor: Color = MaterialTheme.colorScheme.surfaceTint,
                 backColor: Color = MaterialTheme.colorScheme.secondaryContainer,
                 borderColor: Color = MaterialTheme.colorScheme.inversePrimary,
                 onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick),
        border = BorderStroke(2.dp, borderColor),
        colors = CardDefaults.cardColors(containerColor = backColor),
//        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp, pressedElevation = 2.dp)
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
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}
@Composable
fun OrderRow(
    theList: CustomerOrders,
    prod: Product,
    amount: Int,
    showDeleteButton: Boolean = true,
    context: Context? = null
) {
    val fontSize = 20.sp
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable{
                theList.check(prod)
            },
        colors = CardDefaults.cardColors(
            containerColor =
                if (theList.isChecked(prod)) Color.Green
                else CardDefaults.cardColors().containerColor),
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
                CommonButton(
                    modifier = Modifier.padding(end = 8.dp),
                    icon = Icons.Default.Add,
                    onClick = {
                        theList.plus(prod, updateRecentOrder = true)
                        context?.let{ theList.saveToPreferences(context) }
                    }
                )
                CommonButton(
                    modifier = Modifier.padding(end = 8.dp),
                    icon = Icons.Default.Remove,
                    onClick = {
                        theList.minus(prod)
                        context?.let{ theList.saveToPreferences(context) }
                    }
                )
            }

            // TITLE AND AMOUNT
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = prod.title,
                        fontSize = fontSize,
                        color =
                            if (theList.isChecked(prod)) Color.Black
                            else Color.Unspecified
                    )
                }
                Text(
                    text = "x$amount",
                    fontSize = fontSize,
                    color =
                        if (theList.isChecked(prod)) Color.Black
                        else Color.Unspecified,
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
                    CommonButton(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        icon = Icons.Default.Close,
                        backColor = Color.Red,
                        onClick = {
                            theList.minus(prod, amount)
                        }
                    )
                }
            }
        }
    }
}
@Composable
fun ProductCard(
    prod: Product,
    onProductClicked: (Product) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .padding(8.dp)
            .clickable {
                onProductClicked(prod)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp, pressedElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = prod.imgId),
                contentDescription = prod.title,
                modifier = Modifier.size(80.dp)
            )
            Text(
                prod.title, textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(Color.Gray.copy(alpha = 0.5f))
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 100, uiMode = UI_MODE_NIGHT_MASK)
@Composable
fun PreviewCommonButton(){
    CommonButton(
        icon = Icons.Default.Share,
        title = "Share"
    )
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun PreviewOrderRow(){
    OrderRow(CustomerOrders(),Product.BBQ_PACKS,1, true)
}

@Preview(showBackground = true, widthDp = 100)
@Composable
fun PreviewProductCard() {
    ProductCard(Product.COCA_COLA)
}

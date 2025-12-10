package com.ferhat.bringitems

import CustomerOrders
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ferhat.bringitems.ui.theme.BringItemsTheme
import ui.OrderList
import ui.ProductsGrid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val tabs = listOf("Products", "List")
            var mySelectedTabIndex by remember { mutableIntStateOf(0) }
            var bringItemList = remember { mutableStateOf(CustomerOrders()) }
            BringItemsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        TabRow(
                            selectedTabIndex = mySelectedTabIndex,
                            containerColor = MaterialTheme.colorScheme.surface,
                            contentColor = MaterialTheme.colorScheme.primary,
                            indicator = { positions ->
                                TabRowDefaults.PrimaryIndicator(
                                    modifier = Modifier.tabIndicatorOffset(positions[mySelectedTabIndex]),
                                    width = positions[mySelectedTabIndex].width
                                )
                            }
                        ) {
                            tabs.forEachIndexed { index, title ->
                                Tab(
                                    selected = mySelectedTabIndex == index,
                                    onClick = { mySelectedTabIndex = index },
                                    text = { Text(text = title) }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    when(mySelectedTabIndex) {
                        0 -> ProductsGrid(
                            modifier = Modifier.padding(innerPadding),
                            inputItems = Product.values().toList()
                        ) { prod ->
                            bringItemList.value.plus(prod)
                        }
                        1 -> OrderList(bringItemList.value, Modifier.padding(innerPadding))
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BringItemsTheme {
        Greeting("Android")
    }
}
package com.ferhat.bringitems

import CustomerOrders
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ferhat.bringitems.ui.theme.BringItemsTheme
import kotlinx.coroutines.launch
import ui.ListOperationsBar
import ui.OrderList
import ui.ProductsGrid
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val tabs = listOf("Products", "List")
            val pagerState = rememberPagerState(pageCount = { tabs.size })
            val scope = rememberCoroutineScope()
            val bringItemList = remember { mutableStateOf(CustomerOrders()) }

            BringItemsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        TabRow(
                            selectedTabIndex = pagerState.currentPage,
                            containerColor = MaterialTheme.colorScheme.surface,
                            contentColor = MaterialTheme.colorScheme.primary,
                            indicator = { positions ->
                                TabRowDefaults.PrimaryIndicator(
                                    modifier = Modifier.tabIndicatorOffset(positions[pagerState.currentPage]),
                                    width = positions[pagerState.currentPage].width
                                )
                            }
                        ) {
                            tabs.forEachIndexed { index, title ->
                                Tab(
                                    selected = pagerState.currentPage == index,
                                    onClick = {
                                        scope.launch {
                                            pagerState.animateScrollToPage(index)
                                        }
                                    },
                                    text = { Text(text = title) }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.padding(innerPadding)
                    ) { page ->
                        when (page) {
                            0 -> ProductsGrid(
                                modifier = Modifier.padding(innerPadding),
                                inputItems = Product.values().toList()
                            ) { prod ->
                                bringItemList.value.plus(prod)
                            }

                            1 -> {
                                val context = LocalContext.current
                                Column(
                                    Modifier
                                        .padding(innerPadding)
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    OrderList(
                                        bringItemList.value,
                                        Modifier
                                            .weight(1f)
                                            .padding(innerPadding)
                                    )
                                    ListOperationsBar(
                                        onShareButtonClicked = {
                                            shareText(context, exportTheList(bringItemList))
                                        },
                                        onClearButtonClicked = {
                                            bringItemList.value.clearAll()
                                        }
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

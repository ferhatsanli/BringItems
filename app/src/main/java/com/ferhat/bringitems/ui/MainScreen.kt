package com.ferhat.bringitems.ui

import CustomerOrders
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ferhat.bringitems.ProductCategory
import com.ferhat.bringitems.exportTheList
import com.ferhat.bringitems.shareText
import com.ferhat.bringitems.ui.theme.BringItemsTheme
import kotlinx.coroutines.launch
import ui.ListOperationsBar
import ui.OrderList
import ui.OrderRow
import ui.ProductsGrid

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    BringItemsTheme {
        val tabs = listOf("Products", "List")
        val pagerState = rememberPagerState(pageCount = { tabs.size })
        val scope = rememberCoroutineScope()
        val bringItemList = remember { mutableStateOf(CustomerOrders()) }
        val navController = rememberNavController()
        val targetCategory = remember { mutableStateOf(ProductCategory.ALL) }
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
                    0 -> {
                        Column(
                            modifier = Modifier.padding(top = innerPadding.calculateTopPadding()),
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = NavProducts.CATEGORIES.name,
                                modifier = Modifier.weight(1f)
                            ){
                                composable(NavProducts.CATEGORIES.name){
                                    CategoriesPage(ProductCategory.entries){ selected ->
                                        targetCategory.value = selected
                                        navController.navigate(NavProducts.ITEMS.name)
                                    }
                                }
                                composable(NavProducts.ITEMS.name) {
                                    ProductsGrid(
                                        modifier = Modifier.weight(1f),
                                        inputItems = Product.entries.filter{ it.categories.contains(targetCategory.value)}
                                    ) { prod ->
                                        bringItemList.value.plus(prod, updateRecentOrder = true)
                                    }
                                }
                            }

                            if (bringItemList.value.getOrders().isNotEmpty()){
                                OrderRow(
                                    theList = bringItemList.value,
                                    prod = bringItemList.value.getRecentOrder(),
                                    amount = bringItemList.value.getRecentOrderAmount(),
                                    showDeleteButton = false
                                )
                            }
                        }
                    }

                    1 -> {
                        val context = LocalContext.current
                        Column(
                            Modifier
                                .padding(top = innerPadding.calculateTopPadding())
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
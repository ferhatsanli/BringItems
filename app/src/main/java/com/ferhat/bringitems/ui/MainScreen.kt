package com.ferhat.bringitems.ui

import CustomerOrders
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.PrimaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ferhat.bringitems.ProductCategory
import com.ferhat.bringitems.exportTheList
import com.ferhat.bringitems.shareText
import com.ferhat.bringitems.ui.theme.BringItemsTheme
import kotlinx.coroutines.launch
import toDp
import ui.ProductsGrid

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun MainScreen() {

    BringItemsTheme {
        val tabs = listOf("Products", "List")
        val pagerState = rememberPagerState(pageCount = { tabs.size })
        val scope = rememberCoroutineScope()
        val bringItemList = remember { mutableStateOf(CustomerOrders()) }
        val navController = rememberNavController()
        val targetCategory = remember { mutableStateOf(ProductCategory.ALL) }
//        BackHandler {
//            if (navController.previousBackStackEntry != null) {
//                navController.navigateUp()
//            }
//        }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text("Bring Items") },
                    navigationIcon = {
                        if (navController.previousBackStackEntry != null) {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    }
                )
            },
            bottomBar = {
                SecondaryTabRow(selectedTabIndex = pagerState.currentPage) {
                    tabs.forEachIndexed{ index, title ->
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
                            modifier = Modifier//.padding(top = innerPadding.calculateTopPadding()),
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = NavProducts.CATEGORIES.name,
                                modifier = Modifier.weight(1f)
                            ) {
                                composable(NavProducts.CATEGORIES.name) {
                                    CategoriesPage(ProductCategory.entries) { selected ->
                                        targetCategory.value = selected
                                        navController.navigate(NavProducts.ITEMS.name)
                                    }
                                }
                                composable(NavProducts.ITEMS.name) {
                                    ProductsGrid(
                                        modifier = Modifier.weight(1f),
                                        inputItems = Product.entries.filter {
                                            it.categories.contains(
                                                targetCategory.value
                                            )
                                        }
                                    ) { prod ->
                                        bringItemList.value.plus(prod, updateRecentOrder = true)
                                    }
                                }
                            }

                            if (bringItemList.value.getOrders().isNotEmpty() &&
                                bringItemList.value.getRecentOrderAmount() > 0) {
                                OrderRow(
                                    theList = bringItemList.value,
                                    prod = bringItemList.value.getRecentOrder(),
                                    amount = bringItemList.value.getRecentOrderAmount(),
                                    showDeleteButton = true
                                )
                            }
                        }
                    }

                    1 -> {
                        val context = LocalContext.current
                        Column(
                            Modifier
                                //.padding(top = innerPadding.calculateTopPadding())
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            OrderList(
                                bringItemList.value,
                                Modifier
                                    .weight(1f)
                                //.padding(innerPadding)
                            )
                            ListOperationsBar(
                                onShareButtonClicked = {
                                    if (bringItemList.value.getSize() > 0)
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
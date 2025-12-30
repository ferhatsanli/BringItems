package com.ferhat.bringitems.data.repository

import CustomerOrders
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.MutableState

fun exportTheList(theList: MutableState<CustomerOrders>): String {
    return theList.value.getSortedOrdersList()
        .joinToString(separator = "\n") { (product, amount) -> "${product.title} x$amount" }
}

fun shareText(context: Context, text: String) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val chooser = Intent.createChooser(sendIntent, "Share the list")
    try {
        context.startActivity(chooser)
    } catch (e: ActivityNotFoundException) {
        println(e.message)
    }
}
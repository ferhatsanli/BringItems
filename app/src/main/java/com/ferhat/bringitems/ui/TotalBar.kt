package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import to2Digits

@Composable
fun TotalBar(total: Float) {
    Box (
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
    ) {
        Column (
//            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Total: ${total.to2Digits()}", fontSize = 24.sp)
        }
    }
}


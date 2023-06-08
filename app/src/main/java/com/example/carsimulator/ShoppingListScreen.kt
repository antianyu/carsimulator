package com.example.carsimulator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carsimulator.ui.theme.CarSimulatorTheme

/**
 * 主界面
 *
 * @author Tianyu An
 */
@Composable
fun ShoppingListScreen(items: List<Item>) {
    CarSimulatorTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items.size) { index ->
                    ShoppingListItem(item = items[index])
                }
            }
        }
    }
}

@Composable
fun ShoppingListItem(item: Item) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(start = 16.dp)
            .clickable {
                item.showCount = item.showCount - 1
                if (item.showCount < 0) {
                    item.showCount = item.count
                }
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "${item.name} x ${item.showCount}",
            color = Color.Black,
            fontSize = 24.sp
        )
    }
}

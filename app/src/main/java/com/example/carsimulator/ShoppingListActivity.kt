package com.example.carsimulator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import java.io.Serializable

class ShoppingListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListScreen(items = (intent.getSerializableExtra(KEY_ITEMS) as Map<String, Int>).map { Item(it.key, it.value) }.toMutableList())
        }
    }

    companion object {

        private const val KEY_ITEMS = "items"

        fun launch(context: Context, items: Map<String, Int>) {
            context.startActivity(
                Intent(context, ShoppingListActivity::class.java).apply {
                    putExtra(KEY_ITEMS, items as Serializable)
                }
            )
        }
    }
}

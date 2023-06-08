package com.example.carsimulator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carsimulator.ui.theme.CarSimulatorTheme
import com.google.accompanist.flowlayout.FlowRow

/**
 * 主界面
 *
 * @author Tianyu An
 */
@Composable
fun MainScreen(viewModel: MainViewModel) {
    CarSimulatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(viewModel.data.size) { index ->
                        Section(viewModel.data[index])
                    }
                }
                Row {
                    Box(
                        modifier = Modifier
                            .height(48.dp)
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.primary)
                            .clickable {
                                viewModel.export()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "导出购物单",
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                    val showDialog = remember { mutableStateOf(false) }
                    if (showDialog.value) {
                        ResetDialog(
                            onConfirm = {
                                viewModel.clear()
                                showDialog.value = false
                            },
                            onCancel = {
                                showDialog.value = false
                            }
                        )
                    }
                    Box(
                        modifier = Modifier
                            .height(48.dp)
                            .weight(1f)
                            .background(Color.Red)
                            .clickable {
                                showDialog.value = true
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "重置",
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun Section(section: Section) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = section.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )
        Column(Modifier.fillMaxWidth()) {
            section.parts.forEach {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.width(72.dp).padding(top = 8.dp),
                        text = it.showName,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    FlowRow(
                        modifier = Modifier.weight(1f),
                        mainAxisSpacing = 4.dp,
                        crossAxisSpacing = 4.dp
                    ) {
                        it.subParts?.forEach { subPart ->
                            Text(
                                text = subPart.showName,
                                modifier = Modifier
                                    .background(if (subPart.damaged) Color.Red else MaterialTheme.colorScheme.primary)
                                    .clickable {
                                        subPart.damaged = !subPart.damaged
                                    }
                                    .padding(8.dp),
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun ResetDialog(onConfirm: () -> Unit, onCancel: () -> Unit) {
    AlertDialog(
        onDismissRequest = onCancel,
        title = {
            Text(text = "确认要重置吗")
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "确认", fontSize = 24.sp)
            }
        },
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text(text = "取消", fontSize = 24.sp)
            }
        },
    )
}

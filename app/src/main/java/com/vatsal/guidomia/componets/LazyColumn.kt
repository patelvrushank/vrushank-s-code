package com.vatsal.guidomia.componets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.vatsal.guidomia.dashboard.DashboardViewModel

@Composable
fun DisplayLazyColumnList(viewModel: DashboardViewModel) {
    val carListLiveData = viewModel.carListLiveData
    val carListDataState by carListLiveData.observeAsState(emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item(0) {
            ImageWithTitle()
        }

        itemsIndexed(carListDataState) { index, carItem ->
            CarItem(
                carsItem = carItem,
                isLast = index == carListLiveData.value?.size?.minus(1)
            )
        }
    }
}
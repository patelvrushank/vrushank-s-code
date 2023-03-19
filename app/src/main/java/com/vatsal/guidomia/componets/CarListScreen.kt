package com.vatsal.guidomia.componets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.vatsal.guidomia.dashboard.DashboardViewModel

private const val IMAGE_WITH_TITLE_POSITION = 0

/**
 *  Car List screen.
 */
@Composable
fun CarListScreen(viewModel: DashboardViewModel) {
    val carListLiveData = viewModel.carListLiveData
    val carListDataState by carListLiveData.observeAsState(emptyList())

    val expandPositionLiveData = viewModel.expandPositionLiveData
    val expandPositionDataState by expandPositionLiveData.observeAsState(0)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item(IMAGE_WITH_TITLE_POSITION) {
            ImageWithTitleAndSubHeader()
        }

        itemsIndexed(carListDataState) { index, carItem ->
            ExpandableCarItem(
                carsItem = carItem,
                isLast = index == carListDataState.size.minus(1),
                expandPositionDataState = expandPositionDataState,
                index = index
            ){
                viewModel.setExpandPosition(index)
            }
        }
    }
}
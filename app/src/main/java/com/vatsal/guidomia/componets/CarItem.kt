package com.vatsal.guidomia.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vatsal.guidomia.model.CarsItem
import com.vatsal.guidomia.ui.theme.darkGrey
import com.vatsal.guidomia.ui.theme.lightGrey
import com.vatsal.guidomia.ui.theme.orange
import com.vatsal.guidomia.util.convertToThousands
import com.vatsal.guidomia.util.getImageDrawable

/**
 *  Car Item to be displayed on @CarListScreen.
 */
@Composable
fun CarItem(carsItem: CarsItem, isLast: Boolean, onClick : () -> Unit, expandPositionDataState : Int) {
    Column(modifier = Modifier.background(Color.White)) {

       // Collapsed view
        Row(
            modifier = Modifier
                .background(lightGrey)
                .padding(8.dp)
                .clickable {
                    onClick.invoke()
                }
        ) {
            Image(
                painter = painterResource(id = carsItem.model.getImageDrawable()),
                contentDescription = "Left Image",
                modifier = Modifier
                    .width(120.dp)
                    .height(80.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.FillHeight,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = carsItem.model ?: "",
                    color = darkGrey,
                    fontSize = 18.sp
                )

                Text(
                    text = "Price : ${carsItem.marketPrice?.toInt().convertToThousands()}k",
                    color = darkGrey,
                    fontSize = 10.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                RatingView(rating = carsItem.rating?.toFloat() ?: 0f)

            }
        }

        // Divider
        if (!isLast) {
            Column(modifier = Modifier.height(24.dp), verticalArrangement = Arrangement.Center) {
                Divider(
                    color = orange,
                    thickness = 4.dp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
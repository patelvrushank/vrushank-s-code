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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vatsal.guidomia.R
import com.vatsal.guidomia.model.CarsItem
import com.vatsal.guidomia.ui.theme.darkGrey
import com.vatsal.guidomia.ui.theme.lightGrey
import com.vatsal.guidomia.ui.theme.orange
import com.vatsal.guidomia.util.convertToThousands
import com.vatsal.guidomia.util.getImageDrawable

/**
 *  Car Item to be displayed on @CarListScreen.
 *  @param carsItem - cardItem object
 *  @param isLast - boolean flag to determine the logic to add the divider item
 *  @param onClick - onclick click event on the car item.
 *  @param expandPositionDataState - Int value to determine the expand/collapse the view.
 *  @param index - index of the cardItem.
 */
@Composable
fun ExpandableCarItem(
    carsItem: CarsItem,
    isLast: Boolean,
    onClick: () -> Unit,
    expandPositionDataState: Int,
    index: Int,
) {
    val prosList = carsItem.prosList
    val filteredProsList = prosList?.filter { it?.isNotBlank() == true }

    val consList = carsItem.consList
    val filteredConsList = consList?.filter { it?.isNotBlank() == true }

    Column(modifier = Modifier.background(Color.White)) {
        // CarItems
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
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Price : ${carsItem.marketPrice?.toInt().convertToThousands()}k",
                    color = darkGrey,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                RatingView(rating = carsItem.rating?.toFloat() ?: 0f)

            }
        }

        // Expandable View.
        if (index == expandPositionDataState) {
            Column(modifier = Modifier.background(lightGrey).padding(bottom = 8.dp)) {

                //Pros List
                filteredProsList?.let {
                    if(it.isNotEmpty()) {
                        Column(modifier = Modifier.padding(start = 16.dp)) {
                            Text(
                                text = stringResource(R.string.title_pros),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = darkGrey,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            it.forEach { pros ->
                                Row(
                                    modifier = Modifier
                                        .padding(start = 12.dp, top = 4.dp, bottom = 8.dp)
                                ) {
                                    Text(
                                        text = "\u25CF",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = orange
                                    )

                                    Text(
                                        text = pros ?: "",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                // Cons List
                filteredConsList?.let {
                    if(it.isNotEmpty()) {
                        Column(modifier = Modifier.padding(start = 16.dp)) {
                            Text(
                                text = stringResource(R.string.title_cons),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = darkGrey,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            it.forEach { cons ->
                                Row(
                                    modifier = Modifier
                                        .padding(start = 12.dp, top = 4.dp, bottom = 8.dp)
                                ) {
                                    Text(
                                        text = "\u25CF",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = orange
                                    )

                                    Text(
                                        text = cons ?: "",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Divider
        if (!isLast) {
            Column(modifier = Modifier.height(24.dp), verticalArrangement = Arrangement.Center) {
                Divider(
                    color = orange,
                    thickness = 4.dp,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }
    }
}
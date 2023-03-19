package com.vatsal.guidomia.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vatsal.guidomia.R

/**
 *  ImageView with Title on bottom.
 */
@Composable
fun ImageWithTitle() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.tacoma),
            contentDescription = "tacoma",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.height(250.dp)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.car_title),
                color = Color.White,
                fontSize = 28.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
            Text(
                text = stringResource(R.string.car_subhead),
                color = Color.White,
                fontSize = 14.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            )
        }
    }
}
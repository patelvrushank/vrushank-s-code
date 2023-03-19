package com.vatsal.guidomia.componets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.vatsal.guidomia.R
import com.vatsal.guidomia.ui.theme.orange

@Composable
fun RatingView(
    rating: Float,
    maxRating: Int = 5,
    emptyIcon: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_star_border_24) ,
    filledIcon: ImageVector = Icons.Default.Star,
    tint: Color = orange
) {
    Row {
        for (i in 1..maxRating) {
            val icon = if (i <= rating) filledIcon else emptyIcon
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = tint,
                modifier = Modifier.size(12.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

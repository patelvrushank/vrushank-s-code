package com.vatsal.guidomia.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vatsal.guidomia.R
import com.vatsal.guidomia.componets.ImageWithTitle
import com.vatsal.guidomia.componets.MyToolbar
import com.vatsal.guidomia.ui.theme.GuidomiaTheme

class DashboardActivity : ComponentActivity() {

    val viewModel : DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuidomiaTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        MyToolbar(title = getString(R.string.app_name))
                    },
                    content = {
                        // Add the rest of your UI content here
                        ImageWithTitle()
                    }
                )

            }
        }
    }
}
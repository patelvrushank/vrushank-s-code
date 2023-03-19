package com.vatsal.guidomia.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vatsal.guidomia.R
import com.vatsal.guidomia.componets.CarListScreen
import com.vatsal.guidomia.componets.Toolbar
import com.vatsal.guidomia.ui.theme.GuidomiaTheme
import com.vatsal.guidomia.ui.theme.darkGrey
import com.vatsal.guidomia.ui.theme.lightGrey
import com.vatsal.guidomia.ui.theme.orange

class DashboardActivity : ComponentActivity() {

    private val viewModel: DashboardViewModel by viewModels {
        DashBoardViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuidomiaTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        Toolbar(title = getString(R.string.app_name))
                    },
                    content = {
                        // Add the rest of your UI content here
                        CarListScreen(viewModel)
                    }
                )
            }
        }
        viewModel.fetchCarList()
    }
}

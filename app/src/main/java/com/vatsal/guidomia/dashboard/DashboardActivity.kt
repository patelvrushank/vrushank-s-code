package com.vatsal.guidomia.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import com.vatsal.guidomia.R
import com.vatsal.guidomia.componets.CarListScreen
import com.vatsal.guidomia.componets.Toolbar
import com.vatsal.guidomia.ui.theme.GuidomiaTheme

/**
 * Dashboard activity to display list of cars.
 */
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

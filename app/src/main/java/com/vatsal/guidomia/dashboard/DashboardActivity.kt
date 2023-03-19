package com.vatsal.guidomia.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import com.vatsal.guidomia.R
import com.vatsal.guidomia.componets.DisplayLazyColumnList
import com.vatsal.guidomia.componets.MyToolbar
import com.vatsal.guidomia.ui.theme.GuidomiaTheme

class DashboardActivity : ComponentActivity() {

    private val viewModel: DashboardViewModel by viewModels {
        MyViewModelFactory(application)
    }

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
                        DisplayLazyColumnList(viewModel)
                    }
                )
            }
        }
        viewModel.fetchCarList()
    }
}
package com.vatsal.guidomia.dashboard

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DashBoardViewModelFactory(private val someParameter: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(someParameter) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

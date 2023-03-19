package com.vatsal.guidomia.dashboard

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vatsal.guidomia.model.CarsItem
import java.io.IOException

/**
 * Viewmodel class for dashboard activity.
 */
class DashboardViewModel(private val app: Application) : AndroidViewModel(app) {

    private val TAG = DashboardViewModel::class.java.simpleName

    private var _carListLiveData = MutableLiveData<List<CarsItem>>()
    val carListLiveData: LiveData<List<CarsItem>> = _carListLiveData

    private var _expandPosition = MutableLiveData(0)
    val expandPositionLiveData : LiveData<Int>  = _expandPosition

    /**
     * Fun to read the car_list.json file from assets folder.
     */
    fun fetchCarList() {
        try {
            val inputStream = app.applicationContext.assets.open("car_list.json")
            val json = inputStream.bufferedReader().use { it.readText() }

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val adapter = moshi.adapter<List<CarsItem>>(
                Types.newParameterizedType(
                    List::class.java,
                    CarsItem::class.java
                )
            )
            val cars = adapter.fromJson(json)
            _carListLiveData.value = cars

            println("Cars : ${cars.toString()}")

        } catch (exception: IOException) {
            Log.e(TAG, "Failed to retrieve json from asset folder $exception")
        }
    }

    fun setExpandPosition(position : Int){
        _expandPosition.value = position
    }
}
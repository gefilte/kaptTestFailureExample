package com.example.kapttestfailureexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {

        var activityDaggerComponent: ActivityDaggerComponent = DaggerActivityDaggerComponent.builder().build()
    }

    @Inject lateinit var coffeePot: CoffeePot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityDaggerComponent.inject(this)
    }
}

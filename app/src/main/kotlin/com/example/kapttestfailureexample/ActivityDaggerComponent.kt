package com.example.kapttestfailureexample

import dagger.Component
import javax.inject.Singleton

/**
 * Created by dpisoni on 5/18/17.
 */

@Singleton
@Component(modules = arrayOf(CoffeePotModule::class))
interface ActivityDaggerComponent {
    fun inject(activity: MainActivity)
}

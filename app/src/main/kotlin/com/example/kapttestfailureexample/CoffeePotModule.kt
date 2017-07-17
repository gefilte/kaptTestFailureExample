package com.example.kapttestfailureexample

import com.example.kapttestfailureexample.CoffeePot
import dagger.Module
import dagger.Provides

/**
 * Created by dpisoni on 5/18/17.
 */

@Module
class CoffeePotModule() {
    @Provides fun provideCoffeePot() = CoffeePot()
}

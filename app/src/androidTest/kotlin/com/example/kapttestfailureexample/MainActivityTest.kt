package com.example.kapttestfailureexample

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import dagger.Component
import dagger.Module
import dagger.Provides
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.test.assertTrue

/**
 * Created by dpisoni on 7/17/17.
 */

class MockCoffeePot: CoffeePot()

@Module
class MockCoffeePotModule {
    @Provides fun provideCoffeePot(): CoffeePot = MockCoffeePot()
}


@Singleton
@Component(modules = arrayOf(MockCoffeePotModule::class))
interface TestActivityDaggerComponent : ActivityDaggerComponent {
    fun inject(mainActivityTest: MainActivityTest)
}

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField var activityRule = object : ActivityTestRule<MainActivity>(MainActivity::class.java, true, false) {
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            MainActivity.activityDaggerComponent = activityComponent
        }
    }


    lateinit var activityComponent: TestActivityDaggerComponent
    @Inject lateinit var coffeePot: CoffeePot

    @Before
    fun setupDagger() {
        activityComponent = DaggerTestActivityDaggerComponent.builder().build()
        activityComponent.inject(this)
    }

    @Test
    fun testCoffeePot() {
        assertTrue(coffeePot.isShortAndStout)
    }
}

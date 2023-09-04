package com.example.appcomparador

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appcomparador.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CompareActivityTest {
    @get: Rule
    val rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_comparatorTextsEqual() {
        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).perform(
            typeText("hello")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editText2)
        ).perform(
            typeText("hello")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultTextView)
        ).check(
            matches(
                withText("Los textos son iguales")
            )
        )
    }

    @Test
    fun mainActivity_comparatorTextsNoEqual() {
        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).perform(
            typeText("hello")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editText2)
        ).perform(
            typeText("HELLO")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultTextView)
        ).check(
            matches(
                withText("Los textos NO son iguales")
            )
        )
    }

    @Test
    fun mainActivity_comparatorTextsVoid() {
        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultTextView)
        ).check(
            matches(
                withText("Los textos son iguales")
            )
        )
    }
}
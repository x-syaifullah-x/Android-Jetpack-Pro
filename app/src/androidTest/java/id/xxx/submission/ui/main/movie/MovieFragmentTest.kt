package id.xxx.submission.ui.main.movie

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.xxx.submission.R
import id.xxx.submission.R.id.fragment_movie
import id.xxx.submission.R.navigation.nav_graph_home
import id.xxx.submission.SingleNavigationActivity
import id.xxx.submission.data.model.MovieResultModel
import id.xxx.submission.utils.EspressoIdlingResource
import kotlinx.android.synthetic.main.fragment_movie.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random.Default.nextInt

class MovieFragmentTest {

    @get:Rule
    val asr = ActivityScenarioRule(SingleNavigationActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun fragment_loaded() {
        val scenario = asr.scenario
        scenario.onActivity { it.startDestination(nav_graph_home, fragment_movie) }
        onView(withId(R.id.movie_recycler_view)).check(matches(isDisplayed()))

        val data = mutableListOf<MovieResultModel>()
        scenario.onActivity { activity ->
            (activity.movie_recycler_view.adapter as AdapterMovie).currentList?.map { data.add(it) }
        }

        onView(withId(R.id.movie_recycler_view)).perform(scrollToPosition<ViewHolder>(data.size - 1))

        if (data.size > 0) {
            onView(withId(R.id.movie_recycler_view))
                .perform(actionOnItemAtPosition<ViewHolder>(nextInt(0, data.size - 1), click()))
        }
    }
}
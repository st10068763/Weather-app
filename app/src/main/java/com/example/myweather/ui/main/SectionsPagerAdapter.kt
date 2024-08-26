package com.example.myweather.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myweather.CityWeather
import com.example.myweather.DailyForecastsFragment
import com.example.myweather.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PlaceholderFragment.newInstance(position + 1)
            1 -> DailyForecastsFragment()
            2 -> CityWeather()
            else -> throw IndexOutOfBoundsException("No fragment exists for position $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }
}
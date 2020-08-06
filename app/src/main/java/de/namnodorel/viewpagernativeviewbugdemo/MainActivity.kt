package de.namnodorel.viewpagernativeviewbugdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewpager)
        viewPager.adapter = VPAdapter(this)
    }

    class VPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount() = 2

        override fun createFragment(position: Int) = when(position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> throw IllegalStateException("There is no third page!")
        }

    }
}
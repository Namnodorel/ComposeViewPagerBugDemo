package de.namnodorel.viewpagernativeviewbugdemo

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Recomposer
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FrameLayout(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view as ViewGroup).setContent(Recomposer.current()) {
            AndroidView({ context ->
                val tv = TextView(context)
                tv.text = "This native view will make the app crash when you swipe to the other screen and back."
                tv.setTextColor(Color.RED)
                return@AndroidView tv
            }, modifier = Modifier.fillMaxSize())
        }
    }
}

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FrameLayout(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view as ViewGroup).setContent(Recomposer.current()) {
            Text("Wohoo! A second page!\nAs a kid, I've always dreamed about being on the second page of a ViewPager! So exciting!", color = androidx.compose.ui.graphics.Color.Blue)
        }
    }
}
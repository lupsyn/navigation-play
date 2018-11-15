package it.enrico.navigation_play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard_details.*
import kotlin.LazyThreadSafetyMode.NONE

class DashboardDetails : Fragment() {

    private val title by lazy(NONE) { arguments?.getString("DashboardDetailsTitle") ?: "" }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_dashboard_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dashboardDetailsFragmentLabel.text = title
    }
}

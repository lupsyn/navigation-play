package it.enrico.navigation_play

class Navigation(val view: NavigationView) {

    fun selectBottomNavigationTab(bottomNavigationTabId: Int) {
        when (bottomNavigationTabId) {
            R.id.actionHome -> view.showHostView(R.id.homeNavigationFragment)
            R.id.actionDashboard -> view.showHostView(R.id.dashboardNavigationFragment)
            R.id.actionNotifications -> view.showHostView(R.id.notificationNavigationFragment)
        }
    }


}
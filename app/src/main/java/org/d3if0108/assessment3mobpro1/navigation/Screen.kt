package org.d3if0108.assessment3mobpro1.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("homeScreen")
    data object InfoObat : Screen("infoObatScreen")
    data object About : Screen("aboutScreen")
}

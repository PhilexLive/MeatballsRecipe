package com.philexliveprojects.meatballsrecipe.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.philexliveprojects.meatballsrecipe.R

val Margin = 12.dp

enum class Screen {
    Home, First, Second, Third, Fourth, Fifth, Sixth, Seventh, Finish
}

@Composable
fun MeatballsRecipe() {
    Box(Modifier.padding(horizontal = Margin)) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Screen.Home.name) {
            composable(Screen.Home.name) {
                HomeScreen { navController.navigate(Screen.First.name) }
            }
            composable(Screen.First.name) {
                MeatballsRecipeStageScreen(
                    title = "1",
                    text = stringResource(R.string.first),
                    onNavigateUp = { navController.navigateUp() },
                    onNavigate = { navController.navigate(Screen.Second.name) }
                )
            }
            composable(Screen.Second.name) {
                MeatballsRecipeStageScreen(
                    title = "2",
                    text = stringResource(R.string.second),
                    onNavigateUp = { navController.navigateUp() },
                    onNavigate = { navController.navigate(Screen.Third.name) }
                )
            }
            composable(Screen.Third.name) {
                MeatballsRecipeStageScreen(
                    title = "3",
                    text = stringResource(R.string.third),
                    onNavigateUp = { navController.navigateUp() },
                    onNavigate = { navController.navigate(Screen.Fourth.name) }
                )
            }
            composable(Screen.Fourth.name) {
                MeatballsRecipeStageScreen(
                    title = "4",
                    text = stringResource(R.string.fourth),
                    onNavigateUp = { navController.navigateUp() },
                    onNavigate = { navController.navigate(Screen.Fifth.name) }
                )
            }
            composable(Screen.Fifth.name) {
                MeatballsRecipeStageScreen(
                    title = "5",
                    text = stringResource(R.string.fifth),
                    onNavigateUp = { navController.navigateUp() },
                    onNavigate = { navController.navigate(Screen.Sixth.name) }
                )
            }
            composable(Screen.Sixth.name) {
                MeatballsRecipeStageScreen(
                    title = "6",
                    text = stringResource(R.string.sixth),
                    onNavigateUp = { navController.navigateUp() },
                    onNavigate = { navController.navigate(Screen.Seventh.name) }
                )
            }
            composable(Screen.Seventh.name) {
                MeatballsRecipeStageScreen(
                    title = "7",
                    text = stringResource(R.string.seventh),
                    onNavigateUp = { navController.navigateUp() },
                    onNavigate = { navController.navigate(Screen.Finish.name) }
                )
            }
            composable(Screen.Finish.name) {
                FinishScreen {
                    navController.popBackStack(Screen.Home.name, inclusive = false)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MeatballsRecipePreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MeatballsRecipe()
        }
    }
}
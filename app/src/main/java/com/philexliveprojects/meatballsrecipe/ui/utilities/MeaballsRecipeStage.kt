package com.philexliveprojects.meatballsrecipe.ui.utilities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MeatballsRecipeStage(
    title: String,
    text: String,
    onNavigateUp: () -> Unit = {},
    onNavigate: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        MeatballsRecipeText(title, text, Modifier.weight(1f))
        Controller(onNavigateUp, onNavigate)
    }
}

@Preview
@Composable
private fun MeatballsRecipePagePreview() {
    MeatballsRecipeStage("Title", (1..20).joinToString(prefix = "Text, ", postfix = ".") { "text" })
}
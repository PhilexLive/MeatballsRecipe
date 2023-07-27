package com.philexliveprojects.meatballsrecipe.ui.utilities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.meatballsrecipe.ui.Margin

@Composable
fun MeatballsRecipeText(title: String, text: String, modifier: Modifier = Modifier) {
    Card(modifier.wrapContentSize(align = Alignment.Center)) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = title,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = text,
                modifier = Modifier.padding(start = Margin, end = Margin, bottom = 24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun MeatBallsRecipeTextPreview() {
    MeatballsRecipeText(
        title = "Title",
        text = (1..20).joinToString(prefix = "Text, ", postfix = ".") { "text" }
    )
}
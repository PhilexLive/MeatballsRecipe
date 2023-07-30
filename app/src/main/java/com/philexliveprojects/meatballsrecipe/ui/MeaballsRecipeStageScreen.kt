package com.philexliveprojects.meatballsrecipe.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.meatballsrecipe.R
import com.philexliveprojects.meatballsrecipe.ui.utilities.MeatballsRecipeText

@Composable
fun MeatballsRecipeStageScreen(
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = onNavigateUp,
                modifier = Modifier
                    .weight(1f)
                    .widthIn(max = 240.dp)
            ) {
                Text(stringResource(R.string.previous))
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = onNavigate,
                modifier = Modifier
                    .weight(1f)
                    .widthIn(min = 120.dp, max = 240.dp)
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview
@Composable
private fun MeatballsRecipePagePreview() {
    MeatballsRecipeStageScreen("Title", (1..20).joinToString(prefix = "Text, ", postfix = ".") { "text" })
}
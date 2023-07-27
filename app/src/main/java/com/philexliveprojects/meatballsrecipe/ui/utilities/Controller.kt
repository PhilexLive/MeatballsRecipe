package com.philexliveprojects.meatballsrecipe.ui.utilities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.meatballsrecipe.R

@Composable
fun Controller(onNavigateUp: () -> Unit, onNavigate: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
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

@Preview
@Composable
private fun NavigationControllerPreview() {
    Controller({}, {})
}
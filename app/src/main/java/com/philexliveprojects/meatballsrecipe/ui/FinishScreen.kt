package com.philexliveprojects.meatballsrecipe.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.meatballsrecipe.R
import com.philexliveprojects.meatballsrecipe.ui.utilities.MeatballsRecipeText

@Composable
fun FinishScreen(onNavigate: () -> Unit = {}) {
    Column(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            MeatballsRecipeText(
                stringResource(R.string.congratulations),
                stringResource(R.string.finish_text)
            )
            Link(
                Modifier
                    .wrapContentWidth()
                    .align(Alignment.End)
                    .padding(end = 16.dp)
            )
        }
        Button(
            onClick = onNavigate,
            Modifier
                .fillMaxWidth()
                .widthIn(120.dp, 360.dp)
        ) {
            Text(stringResource(R.string.finish))
        }
    }
}

@Composable
private fun Link(modifier: Modifier) {
    val uriHandler = LocalUriHandler.current
    ClickableText(
        text = buildAnnotatedString { append(stringResource(R.string.source)) },
        onClick = { uriHandler.openUri("https://savvybites.co.uk/meatballs-in-tomato-sauce") },
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall.copy(
            color = MaterialTheme.colorScheme.tertiary
        )
    )
}

@Preview
@Composable
private fun FinishScreenPreview() {
    FinishScreen()
}

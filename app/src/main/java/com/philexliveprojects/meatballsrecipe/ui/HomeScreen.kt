package com.philexliveprojects.meatballsrecipe.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.meatballsrecipe.R

@Composable
fun HomeScreen(onNavigate: () -> Unit = {}) {
    Column(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .wrapContentSize(align = Alignment.Center)
        ) {
            Image(
                painterResource(R.drawable.meatballs),
                null,
                Modifier
                    .size(240.dp)
                    .padding(vertical = 56.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )
            Text(
                stringResource(R.string.meatballs_in_tomato_sauce),
                Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge
            )
        }
        Button(
            onClick = onNavigate,
            Modifier
                .fillMaxWidth()
                .widthIn(120.dp, 360.dp)
        ) {
            Text(stringResource(R.string.start))
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
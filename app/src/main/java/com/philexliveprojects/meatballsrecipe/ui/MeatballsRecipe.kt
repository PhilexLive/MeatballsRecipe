package com.philexliveprojects.meatballsrecipe.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.meatballsrecipe.R

val Margin = 12.dp

@Composable
fun MeatballsRecipe() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = Margin)
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
            "Meatballs in Tomato Sauce Recipe",
            Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(24.dp))
        var number = 1
        stringArrayResource(R.array.stages).forEach {
            RecipeStageText(number = number, text = it)
            Spacer(Modifier.height(6.dp))
            number++
        }
        Link(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 12.dp, top = 6.dp, end = 12.dp, bottom = 24.dp)
        )
    }
}

@Composable
fun RecipeStageText(number: Int, text: String) {
    Card {
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = number.toString(),
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

@Composable
fun Link(modifier: Modifier) {
    val uriHandler = LocalUriHandler.current
    ClickableText(
        text = buildAnnotatedString { append(stringResource(R.string.source)) },
        onClick = { uriHandler.openUri("https://savvybites.co.uk/meatballs-in-tomato-sauce") },
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall.copy(
            color = MaterialTheme.colorScheme.tertiary
        )
    )
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
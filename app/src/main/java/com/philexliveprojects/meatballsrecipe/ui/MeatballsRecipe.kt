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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.meatballsrecipe.R
import com.philexliveprojects.meatballsrecipe.ui.theme.Green100
import com.philexliveprojects.meatballsrecipe.ui.theme.GreenA700

@Composable
fun MeatballsRecipe() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 12.dp, end = 12.dp, bottom = 32.dp)
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
        val uriHandler = LocalUriHandler.current
        Spacer(Modifier.height(24.dp))
        Text(Data.text, Modifier.fillMaxWidth())
        ClickableText(
            Data.linkText,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                Data.linkText.getStringAnnotations("URL", it, it).firstOrNull()
                    ?.let { stringAnnotation -> uriHandler.openUri(stringAnnotation.item) }
            }
        )
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

object Data {
    val text: AnnotatedString
        get() = buildAnnotatedString {
            append(
                "• Make the meatball mix, by placing the mince and add in the herbs, the egg and a splash of milk. Using your hands or a wooden spoon, gently mix and form into meatballs. The key to keeping the mince from going tough is being gentle when you roll the meatballs.\n\n" +
                        "• Using milk is the secret to getting juicy, moist meatballs every single time making them light and spongy.\n\n" +
                        "• The next step is mixing your meat mixture until the ingredients are just incorporated with your hands.  Full pieces of ground meat should still be visible.\n\n" +
                        "• Roll your meatballs with lightly oiled hands to prevent the meat from sticking to your fingers, while adding a little extra moisture into each meatball.\n\n" +
                        "• Heat some oil in a pan for browning the meatballs. We just fry them quickly to get colour on them and to form a golden crust and they finish cooking in the sauce. I used a nonstick skillet for this, but you can use a high sided regular skillet and make the sauce in it too.\n\n" +
                        "• Once the meatballs are browned all the way around remove them from the pan and set onto a baking tray. You may need to do this in batches to brown all the meatballs. This recipe makes 20 meatballs.\n\n" +
                        "• To make the sauce, heat some oil in a pan and soften the onion and garlic on medium heat. Add in some thyme and the tomato puree. Give it all a good stir and add in the passata. Add the meatballs to the sauce and simmer for about 10 minutes until the meatballs are cooked through.\n\n"
            )
        }
    val linkText: AnnotatedString
        get() = buildAnnotatedString {
            val text = "Italian Meatballs in Tomato Sauce (All ingredients from Aldi) - Savvy Bites"
            val start = 0
            val end = text.length
            append(text)
            addStyle(
                style = SpanStyle(
                    color = GreenA700,
                    textDecoration = TextDecoration.Underline
                ), start = start, end = end
            )
            addStringAnnotation(
                "URL",
                "https://savvybites.co.uk/meatballs-in-tomato-sauce",
                start,
                end
            )
        }
}
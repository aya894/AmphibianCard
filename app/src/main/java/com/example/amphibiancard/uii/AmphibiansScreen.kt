package com.example.amphibiancard.uii

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amphibiancard.R // N'oubliez pas d'importer vos ressources

@Composable
fun AmphibianCard(title: String, description: String, imageResource: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            BasicText(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            BasicText(
                text = description,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun AmphibiansScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicText(
            text = "Amphibians",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(16.dp)
        )
        AmphibianCard(
            title = "Great Basin Spadefoot (Toad)",
            description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
            imageResource = R.drawable.spadefoot_toad // Utilisez l'identifiant de ressource d'image
        )
        AmphibianCard(
            title = "Roraima Bush Toad (Toad)",
            description = "This toad is typically found in South America.",
            imageResource = R.drawable.bush_toad // Utilisez l'identifiant de ressource d'image
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAmphibiansScreen() {
    AmphibiansScreen()
}

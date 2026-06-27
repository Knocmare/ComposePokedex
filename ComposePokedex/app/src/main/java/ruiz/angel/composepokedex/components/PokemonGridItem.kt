package ruiz.angel.composepokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ruiz.angel.composepokedex.R
import ruiz.angel.composepokedex.domain.Pokemon
import ruiz.angel.composepokedex.ui.theme.ElectricYellow

@Composable
fun PokemonGridItem(pokemon: Pokemon, onClick: () -> Unit = {}) {
    Column(Modifier.fillMaxWidth().clickable{onClick()}, horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = pokemon.description,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(150.dp)
            )
            Row(
                Modifier.size(35.dp, 35.dp)
                    .background(ElectricYellow,
                        shape = RoundedCornerShape(40.dp))
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${pokemon.number}",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Text(
            text = "${pokemon.name}",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonGridItemPreview() {
    PokemonGridItem(Pokemon(
        "Pikachu",
        25,
        "Eléctrico",
        "Pokémon de tipo eléctrico",
        0.4f,
        6f,
        true,
        "Gruñido",
        R.drawable.pikachu))
}
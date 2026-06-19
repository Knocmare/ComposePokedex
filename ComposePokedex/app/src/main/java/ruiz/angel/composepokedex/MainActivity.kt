package ruiz.angel.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import ruiz.angel.composepokedex.components.Ability
import ruiz.angel.composepokedex.components.Chip
import ruiz.angel.composepokedex.components.MorePokemons
import ruiz.angel.composepokedex.domain.Pokemon
import ruiz.angel.composepokedex.ui.theme.ComposePokedexTheme
import ruiz.angel.composepokedex.ui.theme.ElectricYellow
import ruiz.angel.composepokedex.ui.theme.White

class MainActivity : ComponentActivity() {
    val pokemon = Pokemon(
        "Pikachu",
        25,
        "Eléctrico",
        "Pokémon de tipo eléctrico",
        0.4f,
        6f,
        true,
        "Gruñido",
        R.drawable.pikachu)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        pokemon = pokemon,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonHeader(name:String, number:Int, fav:Boolean) {
    Row(Modifier.fillMaxWidth().padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Text(name)
            Text(
                "${number}",
                modifier = Modifier.align(Alignment.End)
            )
        }
        Box() {
            Image(
                painter = painterResource(R.drawable.pokeball),
                contentDescription = "Pokeball image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(130.dp).offset(30.dp, 20.dp)
            )
            Image(
                painter = painterResource(
                    if(fav) R.drawable.star_filled else R.drawable.star_outline
                ),
                contentDescription = if(fav) "Yellow star filled" else "Yellow star outline",
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
fun PokemonCard(name:String, number:Int, description:String,
                type:String, weight:Float, height:Float,
                ability:String, image:Int) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(image),
            contentDescription = "Imagen del pokemon",
            Modifier.offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp)
        )
        Card(Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = White)) {
            Column(Modifier.fillMaxWidth()) {
                Chip(type, ElectricYellow,
                    Modifier.padding(top = 70.dp).align(Alignment.CenterHorizontally))

                Row(modifier = Modifier.fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Column {
                        Ability("Row", "Altura", "${height}")
                        Ability("Row", "Peso", "${weight}")
                    }
                    Ability("Column", "Habilidad", ability)
                }

                Row(Modifier.fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 25.dp)) {
                    Text(description)
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    MorePokemons("left", R.drawable.p24, "Arbok", "0024")
                    MorePokemons("right", R.drawable.p26, "Raichu", "0026")
                }
            }
        }
    }
}

@Composable
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(Modifier.background(ElectricYellow, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number,
            pokemon.fav)
        PokemonCard(pokemon.name, pokemon.number,
            pokemon.description, pokemon.type,
            pokemon.weight, pokemon.height,
            pokemon.ability, pokemon.image)
    }
}

@Composable
fun Column(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePokedexTheme {
        Greeting(Pokemon(
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
}

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview() {
    ComposePokedexTheme {
        PokemonHeader("Pikachu", 25, true)
    }
}

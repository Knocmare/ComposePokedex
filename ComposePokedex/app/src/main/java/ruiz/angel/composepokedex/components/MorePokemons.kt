package ruiz.angel.composepokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ruiz.angel.composepokedex.R
import ruiz.angel.composepokedex.ui.theme.ElectricYellow
import ruiz.angel.composepokedex.ui.theme.White

@Composable
fun MorePokemons(position: String, image: Int, name: String, number: String) {
    if (position == "left") {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(image),
                contentDescription = "Imagen del pokemon",
                Modifier.offset(0.dp, 0.dp)
                    .zIndex(2f)
                    .size(130.dp)
            )
            Row {
                Column (
                    Modifier.size(20.dp, 20.dp)
                        .background(
                            Color(0xFF000000),
                            shape = RoundedCornerShape(40.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "<",
                        textAlign = TextAlign.Center,
                        color = White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text("${name} N.° ${number}")
            }
        }
    } else if (position == "right") {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(image),
                contentDescription = "Imagen del pokemon",
                Modifier.offset(0.dp, 0.dp)
                    .zIndex(2f)
                    .size(130.dp)
            )
            Row {
                Text("${name} N.° ${number}")
                Column (
                    Modifier.size(20.dp, 20.dp)
                        .background(
                            Color(0xFF000000),
                            shape = RoundedCornerShape(40.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = ">",
                        textAlign = TextAlign.Center,
                        color = White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MorePokemonsPreview() {
    MorePokemons("right", R.drawable.p24, "Arbok", "0024")
}
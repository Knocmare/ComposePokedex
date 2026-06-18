package ruiz.angel.composepokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ruiz.angel.composepokedex.ui.theme.ElectricYellow

@Composable
fun Chip(text:String, color: Color,
         modifier: Modifier = Modifier) {
    Box(modifier
        .padding(5.dp, 2.dp)
        .background(color, shape = RoundedCornerShape(10.dp))) {
        Text(text)
    }
}

@Preview
@Composable
fun ChipPreview() {
    Chip("Eléctrico", ElectricYellow)
}
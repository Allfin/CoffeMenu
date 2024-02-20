package ac.id.utdi.allfinemaulinaro.coffemenu

import ac.id.utdi.allfinemaulinaro.coffemenu.model.Coffee
import ac.id.utdi.allfinemaulinaro.coffemenu.data.DataSource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ac.id.utdi.allfinemaulinaro.coffemenu.ui.theme.CoffeMenuTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeMenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoffeeApp()
                }
            }
        }
    }
}

@Composable
fun CoffeeApp(modifier: Modifier = Modifier) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = modifier
        ) {
            items(DataSource.coffess) { coffee ->
                CoffeeCard(coffee = coffee)
            }
        }
}

@Composable
// Komponen untuk Card
fun CoffeeCard(coffee: Coffee,modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier.padding(5.dp)
    ){
        Column{
            Image(
                painter = painterResource(id = coffee.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(5.dp)
            ){
                Text(
                    text = stringResource(id = coffee.nameCoffee),
                    style = MaterialTheme.typography.bodyMedium,
                )
                Row {
                    // agar value int menjadi format mata uang rupiah
                    val formatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
                    val formattedPrice = formatter.format(coffee.price.toString().toDouble())
                    Text(
                        text = formattedPrice,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeMenuTheme {
        val coffee = Coffee(R.string.black_coffee_1, 15000, R.drawable.black_coffee_pic_1_square)
        CoffeeCard(coffee = coffee)
    }
}
package ac.id.utdi.allfinemaulinaro.coffemenu.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Coffee(
    @StringRes val nameCoffee: Int,
    val price: Int,
    @DrawableRes val imageRes: Int
)

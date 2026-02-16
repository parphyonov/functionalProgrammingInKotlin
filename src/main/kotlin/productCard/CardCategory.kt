package productCard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CardCategory {
    @SerialName("Electronics")
    ELECTRONICS,

    @SerialName("Clothing")
    CLOTHING,

    @SerialName("Home Goods")
    HOME_GOODS,

    @SerialName("Beauty")
    BEAUTY,

    @SerialName("Sports")
    SPORTS
}
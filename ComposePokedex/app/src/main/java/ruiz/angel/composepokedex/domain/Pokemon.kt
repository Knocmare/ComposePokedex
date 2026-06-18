package ruiz.angel.composepokedex.domain

data class Pokemon (
    val name: String,
    val number: Int,
    val type: String,
    val description: String,
    val height: Float,
    val weight: Float,
    val fav: Boolean,
    val ability: String,
    val image: Int
)
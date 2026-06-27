package ruiz.angel.composepokedex.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokedexMenu

@Serializable
data class PokemonDetailRoute(
    val currentId: Int,
    val previousId: Int,
    val nextId: Int
)

@Serializable
object Login

@Serializable
object Register

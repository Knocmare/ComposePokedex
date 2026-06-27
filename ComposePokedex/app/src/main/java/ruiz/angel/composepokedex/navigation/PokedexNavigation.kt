package ruiz.angel.composepokedex.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ruiz.angel.composepokedex.dummies.showPokemonList
import ruiz.angel.composepokedex.screens.LoginScreen
import ruiz.angel.composepokedex.screens.PokedexMenuScreen
import ruiz.angel.composepokedex.screens.PokemonDetail
import ruiz.angel.composepokedex.screens.RegisterScreen

@Composable
fun PokedexNavigation() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Login,
            Modifier.padding(paddingValues = innerPadding)
        ){
            composable<PokedexMenu> {
                val totalPokemons = showPokemonList().size
                PokedexMenuScreen(
                    pokemonList = showPokemonList(),
                    onPokemonClick = { pokemonIndex ->
                        val prevIndex = if (pokemonIndex - 1 < 0) totalPokemons - 1 else pokemonIndex - 1
                        val nextIndex = if (pokemonIndex + 1 >= totalPokemons) 0 else pokemonIndex + 1

                        navController.navigate(
                            route = PokemonDetailRoute(
                                currentId = pokemonIndex,
                                previousId = prevIndex,
                                nextId = nextIndex
                            )
                        )
                    }
                )
            }

            composable<PokemonDetailRoute> { backStackEntry ->
                val route: PokemonDetailRoute = backStackEntry.toRoute()
                val allPokemons = showPokemonList()

                val currentPokemon = allPokemons[route.currentId]
                val previousPokemon = allPokemons[route.previousId]
                val nextPokemon = allPokemons[route.nextId]

                PokemonDetail(
                    pokemon = currentPokemon,
                    previousPokemon = previousPokemon,
                    nextPokemon = nextPokemon,
                    onNavigateToNeighbor = { neighborId ->
                        val total = allPokemons.size
                        val pId = if (neighborId - 1 < 0) total - 1 else neighborId - 1
                        val nId = if (neighborId + 1 >= total) 0 else neighborId + 1

                        navController.navigate(PokemonDetailRoute(neighborId, pId, nId)) {
                            popUpTo(PokedexMenu)
                        }
                    }
                )
            }

            composable<Login> {
                LoginScreen(
                    onLoginClick = {
                        navController.navigate(route = PokedexMenu) {
                            popUpTo(Login) { inclusive = true }
                        }
                    },
                    onNavigateRegister = {
                        navController.navigate(route = Register)
                    }
                )
            }

            composable<Register> {
                RegisterScreen(
                    onRegisterSuccess = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
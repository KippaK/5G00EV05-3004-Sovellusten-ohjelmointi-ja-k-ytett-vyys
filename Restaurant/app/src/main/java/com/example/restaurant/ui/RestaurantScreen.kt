package com.example.restaurant.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaurant.domain.model.Restaurant

val restaurants = listOf(
    Restaurant("The Gourmet Kitchen", "123 Food St.", 4.5, "Italian"),
    Restaurant("Sushi World", "456 Sushi Ave.", 4.8, "Japanese"),
    Restaurant("Taco Paradise", "789 Taco Blvd.", 4.2, "Mexican"),
    Restaurant("Burger Heaven", "321 Burger Ln.", 4.0, "American"),
    Restaurant("Pasta House", "147 Noodle St.", 4.3, "Italian"),
    Restaurant("Spicy Curry Palace", "852 Spice Rd.", 4.7, "Indian"),
    Restaurant("Le Petit Bistro", "963 French St.", 4.6, "French"),
    Restaurant("Wok 'n' Roll", "258 Noodle Ave.", 4.1, "Chinese"),
    Restaurant("Pizza Planet", "159 Slice Blvd.", 3.9, "Italian"),
    Restaurant("The BBQ Shack", "753 Grill Ln.", 4.4, "American"),
    Restaurant("Ramen Kingdom", "357 Ramen St.", 4.9, "Japanese"),
    Restaurant("Café Mocha", "123 Coffee Rd.", 4.0, "Cafe"),
    Restaurant("Viva la Vegan", "456 Green St.", 4.6, "Vegan"),
    Restaurant("El Toro Loco", "789 Fiesta Ave.", 4.3, "Mexican"),
    Restaurant("Dim Sum Delight", "159 Dumpling Ln.", 4.5, "Chinese"),
    Restaurant("The Greek Taverna", "258 Olive St.", 4.7, "Greek"),
    Restaurant("Kebab Palace", "963 Spice St.", 4.3, "Middle Eastern"),
    Restaurant("The Hot Pot Spot", "654 Boil Ave.", 4.2, "Chinese"),
    Restaurant("Falafel Corner", "321 Vegan Blvd.", 4.0, "Middle Eastern"),
    Restaurant("Seaside Sushi", "753 Ocean Ave.", 4.8, "Japanese"),
    Restaurant("The Taco Stand", "987 Fiesta St.", 3.8, "Mexican"),
    Restaurant("Steakhouse Supreme", "654 Meat Ln.", 4.9, "American"),
    Restaurant("Pho Haven", "258 Soup Ave.", 4.4, "Vietnamese"),
    Restaurant("The Sushi Spot", "951 Fish Blvd.", 4.2, "Japanese"),
    Restaurant("The Vegan Joint", "753 Plant Ave.", 4.7, "Vegan")
)

@Composable
fun RestaurantApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "restaurantList") {
        composable("restaurantList") { RestaurantScreen(navController) }
        composable("restaurantDetails/{name}/{address}/{rating}/{cuisine}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val address = backStackEntry.arguments?.getString("address") ?: ""
            val rating = backStackEntry.arguments?.getString("rating")?.toDouble() ?: 0.0
            val cuisine = backStackEntry.arguments?.getString("cuisine") ?: ""
            RestaurantDetailsScreen(name, address, rating, cuisine)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val filteredRestaurants = restaurants.filter {
        it.name.contains(searchQuery.text, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Find a restaurant") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .systemBarsPadding()
        ) {
            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, shape = MaterialTheme.shapes.small),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (searchQuery.text.isEmpty()) {
                            Text(
                                text = "Search by restaurant name",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredRestaurants) { restaurant ->
                    RestaurantItem(restaurant) {
                        navController.navigate(
                            "restaurantDetails/${restaurant.name}/${restaurant.address}/${restaurant.rating}/${restaurant.cuisine}"
                        )
                    }
                    Divider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f))
                }
            }
        }
    }
}

@Composable
fun RestaurantItem(restaurant: Restaurant, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Text(restaurant.name, style = MaterialTheme.typography.headlineMedium)
        Text("Address: ${restaurant.address}", style = MaterialTheme.typography.bodySmall)
        Text("Rating: ${restaurant.rating}", style = MaterialTheme.typography.bodySmall)
        Text("Cuisine: ${restaurant.cuisine}", style = MaterialTheme.typography.bodySmall)
    }
}

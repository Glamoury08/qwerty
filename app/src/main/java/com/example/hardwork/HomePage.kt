package com.example.hardwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomePage (
    navController: NavController
    ) {
    val data = arrayListOf(
        Product(
            R.drawable.ic_launcher_foreground,
            "android fr",
            200.0
        ),
        Product(
            R.drawable.ic_launcher_background,
            "android bg",
            300.0
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProductList(list = data)
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding (32.dp),
            onClick = {
                navController.navigate("add")
            }
        )
        {
            Icon(
                painter = rememberVectorPainter(image = Icons.Default.Add),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ItemProduct(
    product: Product
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = product.img),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 200.dp, height = 150.dp)
                    .align(Alignment.CenterStart),
                contentScale = ContentScale.Crop
            )
            Text(
                text = product.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            )
            Text(
                text = product.cost.toString(),
                fontSize = 18.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun ProductList  (
    list: MutableList<Product>
) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(list) {
            ItemProduct(product = it)
        }
    }
}

data class Product (
    val img: Int,
    val name: String,
    val cost: Double
)
package com.example.c1v1c2v2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.c1v1c2v2.ui.theme.C1v1c2v2Theme

@Composable
fun StockCreation(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        Button(onClick = { navController.navigate(Screens.Dilution.route) }) {
            Text(text = "to dilution calculation screen")
        }
        Spacer(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Making Molar", fontSize = 28.sp, color = Color.White)
            Text(
                text = "Solutions", fontSize = 34.sp, color = Color.White, style = TextStyle(
                    shadow = Shadow(
                        color = Color.Blue, offset = Offset(5.0f, 10.0f), blurRadius = 3f
                    )
                )
            )
            Spacer(modifier = Modifier
                .height(120.dp)
                .fillMaxWidth())
            Row(){
                Column() {
                    Text(text = "")
                    Row() {
                        Text(text = "grams")
                        Text(text = " = ")
                    }
                }
                Column() {
                    Row(){
                        Text(text = "desired volume (L)")
                        Text(text = " x ")
                        Text(text = "desired molarity (mol/L)")
                    }
                    Row(modifier = Modifier.height(35.dp)) {
                        Text(text = "_".repeat(40))
                    }
                    Row(modifier = Modifier.fillMaxWidth().padding(start = 50.dp)){
                        Text(text = "formula weight (g/mol)")
                    }

                }
            }
            
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    C1v1c2v2Theme {
        StockCreation(navController = rememberNavController())
    }
}
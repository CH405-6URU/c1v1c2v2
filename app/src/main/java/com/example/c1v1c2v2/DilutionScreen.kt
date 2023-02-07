package com.example.c1v1c2v2

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.c1v1c2v2.ui.theme.C1v1c2v2Theme

@Composable
fun ValueInputs(navController: NavController) {
    val context = LocalContext.current
    var concOne by remember {
        mutableStateOf("")
    }
    var volumeOne by remember {
        mutableStateOf("")
    }
    var concTwo by remember {
        mutableStateOf("")
    }
    var volumeTwo by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Button(onClick = { navController.navigate(Screens.Stock.route) }) {
            Text(text = "to stock creation")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 100.dp)
        ) {
            Text(text = "Solution Dilution", fontSize = 28.sp, color = Color.White)
            Text(
                text = "Calculator", fontSize = 34.sp, color = Color.White, style = TextStyle(
                    shadow = Shadow(
                        color = Color.Blue, offset = Offset(5.0f, 10.0f), blurRadius = 3f
                    )
                )
            )
        }
        // working on getting labels readable and even.
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Starting concentration", fontSize = 12.sp, color = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Starting volume",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(end = 15.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = concOne,
                onValueChange = { concOne = it },
                label = { Text("C1") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(100.dp)
                    .background(Color.White)
            )
            Text(text = "X", fontSize = 20.sp, color = Color.White)
            TextField(
                value = volumeOne,
                onValueChange = { volumeOne = it },
                label = { Text("V1") },
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .width(100.dp)
                    .background(Color.White)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Final concentration", fontSize = 12.sp, color = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Final volume",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(end = 15.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = concTwo,
                onValueChange = { concTwo = it },
                label = { Text("C2") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .width(100.dp)
                    .background(Color.White)
            )
            Text(text = "X", fontSize = 20.sp, color = Color.White)
            TextField(
                value = volumeTwo,
                onValueChange = { volumeTwo = it },
                label = { Text("V2") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .width(100.dp)
                    .background(Color.White)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                try {
                    if (concOne == "") {
                        concOne =
                            ((concTwo.toFloat() * volumeTwo.toFloat()) / volumeOne.toFloat()).toString()
                    }
                    if (volumeOne == "") {
                        volumeOne =
                            ((concTwo.toFloat() * volumeTwo.toFloat()) / concOne.toFloat()).toString()
                    }
                    if (concTwo == "") {
                        concTwo =
                            ((concOne.toFloat() * volumeOne.toFloat()) / volumeTwo.toFloat()).toString()
                    }
                    if (volumeTwo == "") {
                        volumeTwo =
                            ((concOne.toFloat() * volumeOne.toFloat()) / concTwo.toFloat()).toString()
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "Enter in 3 of the 4 values", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Calculate", fontSize = 20.sp)
            }
        }
    }
}


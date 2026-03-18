package com.example.navegacaofluxotelas.screens

import android.view.Menu
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavViewModelStoreProvider

@Composable
fun MenuScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF2C4EC7))
            .padding(32.dp),
    ) {
        Text(
            text = "MENU",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )
        Column(
            modifier = Modifier.align(Alignment.Center)
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("perfil/jotarokujo/17")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "PERFIL",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
            Button(
                onClick = {
                    navController.navigate("pedidos?numeroPedido=1234")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "PEDIDOS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
            Button(
                onClick = {
                    navController.popBackStack()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "SAIR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
        }
    }

}
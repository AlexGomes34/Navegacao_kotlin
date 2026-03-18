package com.example.navegacaofluxotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacaofluxotelas.screens.LoginScreen
import com.example.navegacaofluxotelas.screens.MenuScreen
import com.example.navegacaofluxotelas.screens.PedidosScreen
import com.example.navegacaofluxotelas.screens.PerfilScreen
import com.example.navegacaofluxotelas.ui.theme.NavegacaoFluxoTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoFluxoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        }
                    ){
                        composable ( route = "login",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(5000)
                                )
                            }){
                            LoginScreen(navController = navController)
                        }
                        composable ( route = "menu"){
                            MenuScreen(navController = navController)
                        }
                        composable ( route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome"){
                                    type = NavType.StringType
                                },
                                navArgument("idade"){
                                    type = NavType.IntType
                                }
                            )){

                            val idade = it.arguments?.getInt("idade")
                            val nome = it.arguments?.getString("nome")
                            PerfilScreen(
                                navController = navController,
                                nome = nome!!,
                                idade = idade!!)

                        }
                        composable ( route = "pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument(name = "numeroPedido"){
                                    defaultValue = "Sem Pedidos"
                                }
                            )){
                            val numeroPedido = it.arguments?.getString("numeroPedido")
                            PedidosScreen(navController = navController,
                                numeroPedido = numeroPedido!!)
                        }
                     }
                }
            }
        }
    }
}


package com.example.splashscreen

import android.graphics.Paint
import androidx.compose.animation.core.Animatable
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.ui.theme.BottomNavItem
import com.example.splashscreen.ui.theme.SplashScreenTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            SplashScreenTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//            Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()){
//                Navigation()
//            }
//            BottomNavWithBadgesTheme{
//
//            }
        }
    }
}

//@Composable
//fun Navigation(){
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "splash_screen"){
//        composable("splash_screen"){
//            SplashScreen(navController = navController)
//        }
//        composable("main_screen"){
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(color = Color.Black),
//                contentAlignment = Alignment.Center
//            ){
//                Text(text="Main Screen", color = Color.White)
//            }
//        }
//    }
//}
//
//@Composable
//fun SplashScreen(navController: NavController){
//    val scale = remember{
//        Animatable(0f)
//    }
//    LaunchedEffect(key1 = true){
//        scale.animateTo(
//            targetValue = 0.3f,
//            animationSpec = tween(
//                durationMillis = 1000,
//                easing = {
//                    OvershootInterpolator(2f).getInterpolation(it)
//                }
//            )
//        )
//        delay(3000L)
//        navController.navigate("main_screen")
//    }
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = Color.DarkGray),
//
//        ){
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = "Splash Screen Logo",
//            modifier = Modifier.scale(scale.value)
//        )
//    }
//}

@Composable
fun Navigation(navController : NavHostController){
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen()
        }
        composable("chat"){
            ChatScreen()
        }
        composable("settings"){
            SettingsScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items : List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick : (BottomNavItem) -> Unit
){
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(
        modifier = modifier.background(Color.DarkGray)
    ){
        items.forEach{item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(selected = selected,
                onClick = { onItemClick(item)},
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon={

            })}
        }
    }


@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingsScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

    }
}
package com.gpsgeomatiqueagricole.matchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gpsgeomatiqueagricole.matchapp.ui.theme.MatchAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatchAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var matchEnCours by remember { mutableStateOf(false) }
    var matchFini by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ImageBackground()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {
                matchEnCours = !matchEnCours
                matchFini = false
            }) {
                Text("Matchs en cours")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                matchFini = !matchFini
                matchEnCours = false

            }) {
                Text("Matchs finis")
            }
        }
        Spacer(modifier = Modifier.height(26.dp))
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(26.dp))
        if (matchEnCours) {
            Text("Match en cours :", style = TextStyle(fontSize = 26.sp))
            MatchEnCoursList()
        }
        if (matchFini) {
            Text("Match terminés :", style = TextStyle(fontSize = 26.sp))
            Spacer(modifier = Modifier.height(16.dp))
            MatchFiniList()
        }
    }
}

@Composable
fun MatchEnCoursList() {
    val matchs = listOf(
        "-  Paris vs Marseille",
        "-  Lyon vs Toulouse",
        "-  Nice vs Nantes",
        "-  Perpignan vs Angers",
        "-  Biaritz vs Cannet",
        "-  Castres vs Bordeaux",
        "-  Albi vs Lavaur",
        "-  Lille vs Montpellier"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), // Ajuster la hauteur de la colonne en fonction du contenu
        horizontalAlignment = Alignment.CenterHorizontally // Centrer les éléments horizontalement
    ) {
        items(matchs) { match ->
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center // Centrer le contenu à l'intérieur de chaque Box
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .width(250.dp)
                ) {
                    Text(
                        text = match,
                        style = TextStyle(fontSize = 16.sp),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MatchFiniList() {
    val matchs = listOf(
        "-  Madrid  [3] - [0]   Barcelone",
        "-  Rome    [2] - [1]   Milan",
        "-  Berlin  [8] - [2]   Munich",
        "-  London  [1] - [4]   Manchester",
        "-  London  [1] - [4]   Manchester",
        "-  London  [1] - [4]   Manchester",
        "-  Toulon  [2] - [2]   Porto"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), // Ajuster la hauteur de la colonne en fonction du contenu
        horizontalAlignment = Alignment.CenterHorizontally // Centrer les éléments horizontalement
    ) {
        items(matchs) { match ->
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center // Centrer le contenu à l'intérieur de chaque Box
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .width(250.dp)
                ) {
                    Text(
                        text = match,
                        style = TextStyle(fontSize = 16.sp),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageBackground() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Image de fond",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
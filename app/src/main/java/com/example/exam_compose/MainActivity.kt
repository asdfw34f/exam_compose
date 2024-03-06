package com.example.exam_compose

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exam_compose.Room.Models.Avia
import com.example.exam_compose.ui.theme.Exam_composeTheme
import java.text.SimpleDateFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exam_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardEntity(avia: Avia= Avia("qwer", "Moscow", "mow", "Saint-Piter", "led", startDate = SimpleDateFormat("MM.dd.yyyy").parse("12.12.2023"), endDate = SimpleDateFormat("MM.dd.yyyy").parse("02.01.2023"), 1200)) {
    Column {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .border(1.dp, Color.Black, RectangleShape)
            ) {
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color.Black, RectangleShape)
                ) {
                    Column {
                        Text(
                            text = avia.startCity + " --> " + avia.endCity,
                            fontSize =  18.sp,
                            modifier = Modifier
                                .padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Цена: " + avia.price,
                            fontSize = 16.sp,
                            modifier = Modifier
                                    .padding(6.dp),
                            textAlign = TextAlign.Right
                        )
                    }

                }
                Text(
                    text =  "День вылета: " + avia.startDate,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Left
                )
                Text(
                    text =  "День прилета: " +avia.endDate,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Left
                )
                OutlinedButton(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth(),



                ) {
                    Text("В Избранное")
                }
            }
        }
    }
}

@Composable
fun ViewInLazyColumn(aviaList:List<Avia>){
    LazyColumn{
        items(aviaList){ avia->
            CardEntity()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    Exam_composeTheme {
        CardEntity()
    }
}


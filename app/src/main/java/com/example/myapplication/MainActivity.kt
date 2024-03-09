package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val image: Painter = painterResource(id = R.drawable.composelogo)
    val image2: Painter = painterResource(id = R.drawable.coffee)
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    var text by remember {
        mutableStateOf("")
    }

    HorizontalPager(state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->

        if (page == 0) {
            Scaffold(
                bottomBar = {
                    Row(modifier = Modifier.padding(24.dp)) {
                        Button(onClick = { onClick() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF04764E))
                        ) {
                            Text("GET STARTED")
                        }
                    }
                }
            ) {
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        Spacer(Modifier.size(32.dp))
                        Image(painter = image,contentDescription = "", modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(300.dp))
                        Text(text = "Let's meet our summer coffee drinks",
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            style = LocalTextStyle.current.merge(
                                TextStyle(
                                    lineHeight = 1.2.em
                                )
                            )
                        )

                        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            style = LocalTextStyle.current.merge(
                                TextStyle(
                                    lineHeight = 1.2.em
                                )
                            )
                        )
                    }
                }
            }

        } else {
            Scaffold(
                bottomBar = {
                    Row(modifier = Modifier.padding(24.dp)) {
                        Button(onClick = { onClick() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF04764E))
                        ) {
                            Text("GENERATE BILANGAN PRIMA")
                        }
                    }
                }
            ) {
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        Row() {
                            Image(painter = image2,contentDescription = "", modifier = Modifier.size(40.dp))
                            Text(text = "Test Apps",
                                fontWeight = FontWeight.Bold,
                                fontSize = 32.sp,
                                textAlign = TextAlign.Center,
                                style = LocalTextStyle.current.merge(
                                    TextStyle(
                                        lineHeight = 1.2.em
                                    )
                                )
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            Spacer(Modifier.size(32.dp))
                            Text(text = "Bilangan Prima",
                                fontWeight = FontWeight.Bold,
                                fontSize = 32.sp,
                                textAlign = TextAlign.Start,
                                style = LocalTextStyle.current.merge(
                                    TextStyle(
                                        lineHeight = 1.2.em
                                    )
                                )
                            )

                            Text(text = "Masukkan angka untuk menghasilkan bilangan prima.",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                                style = LocalTextStyle.current.merge(
                                    TextStyle(
                                        lineHeight = 1.2.em
                                    )
                                )
                            )

                            TextField(
                                value = text,
                                onValueChange = { text = it },
                                label = { Text("Input angka") },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    disabledContainerColor = Color.Transparent,
                                )
                            )
                        }

                    }
                }
            }



        }


    }



}

fun onClick() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}
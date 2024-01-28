package com.ptk.bizcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ptk.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardAppTheme {
                // A surface container using the 'background' color from the theme
                BuildBizCard()
            }
        }
    }
}

@Composable
fun BuildBizCard() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val list = listOf("Project 1", "Project 2", "Project 3", "Project 4", "Project 5")
        Card(
            elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            var togglePortfolio by remember {
                mutableStateOf(false)
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage(modifier = Modifier.size(200.dp), 0.5f)
                Divider()
                ProfileDetail()
                Button(
                    onClick = { togglePortfolio = !togglePortfolio },
                    modifier = Modifier.padding(top = 16.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Portfolio")
                }
                if (togglePortfolio) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(8.dp)
                            .border(2.dp, color = Color.LightGray)
                    ) {
                        items(list) {
                            ProjectListItem(it)
                        }
                    }
                }
            }


        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier, border: Float) {
    Surface(
        shape = CircleShape,
        border = BorderStroke(border.dp, Color.LightGray),
        shadowElevation = 4.dp,
        modifier = modifier.padding(4.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}

/*@Composable
fun ProfileImageForListItem() {
    Surface(
        shape = CircleShape,
        border = BorderStroke(4.dp, Color.Gray),
        shadowElevation = 4.dp,
        modifier = Modifier.padding(4.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(0.5F)
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
        )
    }
}*/

@Composable
fun ProfileDetail() {

    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Miles P.",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 26.sp
        )
        Text(
            text = "Android Compose Programmer",
            fontSize = 13.sp,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@themilesCompose",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.labelSmall
        )


    }
}

@Composable
fun ProjectListItem(projectName: String) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ), shape = RectangleShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            ProfileImage(modifier = Modifier.size(50.dp), 4f)
            Column(modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)) {
                Text(
                    text = projectName,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "A great project indeed",
                    fontSize = 12.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    BizCardAppTheme {
        ProjectListItem("a")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardAppTheme {
        BuildBizCard()
    }
}
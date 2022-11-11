package pl.sdrozdz.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.sdrozdz.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {
                    BusinessCard(details = PersonDetails(
                        "Sebastian", "Drożdż",
                        "Sofware Developer",
                        phone = "+48 785 363 004",
                        social = "@sdrozdz",
                        email = "seba987xdc@gmail.com"
                    ))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(details: PersonDetails) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        BusinessCardHeader(fullName = "${details.firstName} ${details.lastName}", title = details.title)
        BusinessCardDetails(phone = details.phone, social = details.social, email = details.email)
    }
}

@Composable
fun BusinessCardHeader(fullName: String, title: String) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally)  {

        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier.size(100.dp, 100.dp),
            contentScale = ContentScale.Fit
        )
        Text(text = fullName, fontSize = 36.sp, fontWeight = FontWeight.Light, color = Color.White)
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3ddc84))
    }
}

@Composable
fun BusinessCardDetails(phone: String, social: String, email: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, Color.Cyan))  {

        Text(text = phone)
    }
}

@Preview(showSystemUi = true, backgroundColor = 0xFF073042, showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard(details = PersonDetails(
            "Sebastian", "Drożdż",
            "Sofware Developer",
            phone = "+48 785 363 004",
            social = "@sdrozdz",
            email = "seba987xdc@gmail.com"
        ))
    }
}
package pl.sdrozdz.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
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
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.3f).fillMaxWidth())
        BusinessCardHeader(fullName = "${details.firstName} ${details.lastName}", title = details.title)
        Spacer(modifier = Modifier.fillMaxHeight(0.6f).fillMaxWidth())
        BusinessCardDetails(phone = details.phone, social = details.social, email = details.email)
    }
}

@Composable
fun BusinessCardHeader(fullName: String, title: String) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally)  {

        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier.size(100.dp, 100.dp),
            contentScale = ContentScale.Fit
        )
        Text(text = fullName, fontSize = 36.sp, fontWeight = FontWeight.Light, color = Color.White)
        Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3ddc84))
    }
}

@Composable
fun BusinessCardDetails(phone: String, social: String, email: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight())  {

        val rowModifier = Modifier
            .wrapContentSize(align = Alignment.CenterStart)
            .padding(start = 36.dp, top = 5.dp, bottom = 5.dp)

        Column(modifier = Modifier.fillMaxWidth()) {
            Divider(color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = rowModifier,
            ) {
                Icon(Icons.Filled.Phone, contentDescription = "Phone", tint = Color(0xFF3ddc84))
                Text(text = phone, color = Color.White, modifier = Modifier.padding(start = 16.dp))
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Divider(color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = rowModifier,
            ) {
                Icon(Icons.Filled.Share, contentDescription = "Social", tint = Color(0xFF3ddc84))
                Text(text = social, color = Color.White, modifier = Modifier.padding(start = 16.dp))
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Divider(color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = rowModifier,
            ) {
                Icon(Icons.Filled.Email, contentDescription = "Email", tint = Color(0xFF3ddc84))
                Text(text = email, color = Color.White, modifier = Modifier.padding(start = 16.dp))
            }
        }







    }
}

@Preview(showSystemUi = true, backgroundColor = 0xFF073042, showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard(details = PersonDetails(
            "Jennifer", "Doe",
            "Android Developer Extraordinaire",
            phone = "+11 (123) 444 555 666",
            social = "@AndroidDev",
            email = "jen.doe@android.com"
        ))
    }
}
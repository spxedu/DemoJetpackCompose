package dev.zezo.demojetpackcompose.DemoComponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.zezo.demojetpackcompose.ui.theme.DemoJetpackComposeTheme

class DemoComponentPart02 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Demo component phần 2",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val _context = LocalContext.current
    val scrollState = rememberScrollState() // lưu trạng thai cuôn man hinh

    // Sử dụng Column để hiển thị các component bằng danh sách dọc
    Text(
        text = " $name!".uppercase(),
//        style = TextStyle(color = MaterialTheme.colorScheme.primary ),
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Column (modifier = Modifier.padding(10.dp, 50.dp)
        .verticalScroll(scrollState)// cho phep cuon man hinh
    ){






    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    DemoJetpackComposeTheme {
        Greeting2("Android")
    }
}
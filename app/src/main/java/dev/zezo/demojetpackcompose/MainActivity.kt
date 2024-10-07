package dev.zezo.demojetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.zezo.demojetpackcompose.DemoComponents.DemoComponentPart01
import dev.zezo.demojetpackcompose.DemoComponents.DemoComponentPart02
import dev.zezo.demojetpackcompose.DemoComponents.DemoLazyColumn
import dev.zezo.demojetpackcompose.DemoComponents.DemoLazyGrid_AsyncImage
import dev.zezo.demojetpackcompose.ui.theme.DemoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Home(
                        name = "Demo Kotlin Jetpack Compose",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Home(name: String, modifier: Modifier = Modifier) {
    val ct = LocalContext.current
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = MaterialTheme.typography.titleLarge,
        )
        Button(onClick = {
            val newIntent = Intent(ct,DemoComponentPart01::class.java);
            ct.startActivity( newIntent )
        }) { Text("Demo Component part01") }
        Button(onClick = {
            val newIntent = Intent(ct, DemoComponentPart02::class.java);
            ct.startActivity( newIntent )
        }) {
            Text(text = "Demo Component part02", color =Color.Blue)

        }
        Button(onClick = {
            val newIntent = Intent(ct, DemoLazyColumn::class.java);
            ct.startActivity( newIntent )
        }) {
            Text(text = "Demo LazyColumn", color =Color.Green)

        }
        Button(onClick = {
            val newIntent = Intent(ct, DemoLazyGrid_AsyncImage::class.java);
            ct.startActivity( newIntent )
        }) {
            Text(text = "Demo Grid - Image", color =Color.Red)

        }
    }

}

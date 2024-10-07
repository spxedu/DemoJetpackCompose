package dev.zezo.demojetpackcompose.DemoComponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.zezo.demojetpackcompose.R
import dev.zezo.demojetpackcompose.ui.theme.DemoJetpackComposeTheme
 class DemoLazyGrid_AsyncImage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {

    Column(Modifier.fillMaxSize()) {

        AsyncImage(
//
//            model = ImageRequest.Builder(LocalContext.current)
////                .data("https://i.imgur.com/svViHqm.jpeg")
//                .data("https://i1-vnexpress.vnecdn.net/2024/10/07/china-country-garden-reuters-1-8154-5929-1728274061.jpg?w=380&h=228&q=100&dpr=2&fit=crop&s=sPxD7hQGOdfHn328Tfo6qg")
//                .crossfade(true)
//                .error(R.drawable.ic_launcher_foreground) // Ảnh hiển thị khi có lỗi
//                .build(),
            model = "https://i1-vnexpress.vnecdn.net/2024/10/07/china-country-garden-reuters-1-8154-5929-1728274061.jpg?w=380&h=228&q=100&dpr=2&fit=crop&s=sPxD7hQGOdfHn328Tfo6qg",
            contentScale = ContentScale.Crop,
            contentDescription = null,

            placeholder = painterResource(R.drawable.ic_launcher_background),
            modifier = Modifier.height(100.dp).width(200.dp).border(BorderStroke(2.dp,Color.Red))
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3), //giơới hạn so luong cột
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.height(400.dp)

        ) {
            items(20) { index ->
                Card(
                    modifier = Modifier.padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Text("Item $index")
                }
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        //----------------------------------------------
        val listImage= mutableListOf<String>()
        // thêm san pham vao list
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i1-vnexpress.vnecdn.net/2024/10/07/china-country-garden-reuters-1-8154-5929-1728274061.jpg?w=380&h=228&q=100&dpr=2&fit=crop&s=sPxD7hQGOdfHn328Tfo6qg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")
        listImage.add("https://i.imgur.com/svViHqm.jpeg")

        /* 
        Chú ý: Cần khai báo quyền sử dụng INTERNET và mở usesCleartextTraffic
         <uses-permission android:name="android.permission.INTERNET" />
          <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
            <application
                android:usesCleartextTraffic="true"
        */
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),

            content = {
                items(listImage) { urlImage ->
//                    Text("zzzzz")
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(urlImage)
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                    )
                }
            },
            modifier = Modifier.height(300.dp).fillMaxWidth()
        )




    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    DemoJetpackComposeTheme {
        Greeting4("Android")
    }
}
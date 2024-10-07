package dev.zezo.demojetpackcompose.DemoComponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.zezo.demojetpackcompose.R
import dev.zezo.demojetpackcompose.ui.theme.DemoJetpackComposeTheme

class DemoLazyColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
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
//        .verticalScroll(scrollState)// CHÚ Ý: Bên trong có chứa LazyColumn thì không được phép scroll ở đây
        .fillMaxSize()
    ) {
        //========= bắt đầu phần demo ===============
        LazyColumn {
            // Add a single item
            item {
                Text(text = "Header")
                Text(text = "Header")
            }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        //-----------------------------------------------------
        LazyColumn {
                // Add a single item
            item {
                Text(text = "Header LIST 2222")
            }
                // Add 3 items
            items(3) { index ->
                Text(text = "First List items : $index")
            }
                // Add 2 items
            items(2) { index ->
                Text(text = "Second List Items: $index")
            }
                // Add another single item
            item {
                Text(text = "Footer")
            }
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        //==== Demo danh sách quốc gia
         val countryList = mutableListOf("VietNam", "Lao", "Campuchia", "United States")
         val listModifier = Modifier
            .background(Color.Gray)
            .padding(10.dp)
             .fillMaxWidth()
         val textStyle = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, color = Color.Yellow)
        LazyColumn(modifier = listModifier) {
            items(countryList) {
                    country -> Text(text = country, style = textStyle)
            }
        }

        //======= Column tùy chỉnh ------------
        // tạo trước 1 file model: data class FruitModel(val name:String, val image : Int)
        val fruitsList= mutableListOf<FruitModel>()
        // thêm san pham vao list
        fruitsList.add(FruitModel("Apple", R.drawable.ic_launcher_background))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_launcher_background))
        fruitsList.add(FruitModel("Banana", R.drawable.ic_launcher_background))
        fruitsList.add(FruitModel("Strawberry", R.drawable.ic_launcher_background))
        fruitsList.add(FruitModel("Mango", R.drawable.ic_launcher_background))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White),
            // khoảng cách trong cac phân tử con
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            // khoang cach giua cac dong
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(fruitsList) {
                model -> ListRow(model = model)
            }
        }


        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Demo LazyRow")
        LazyRow {
            items(fruitsList) { item ->
                Column(
                    Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50)),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = item.image),
                        contentDescription = null
                    )
                    Text(text = item.name)
                }
            }
        }


    }
}


@Composable
fun ListRow(model: FruitModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = Color.Blue)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoJetpackComposeTheme {
        Greeting3("Android")
    }
}
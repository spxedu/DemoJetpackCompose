package dev.zezo.demojetpackcompose.DemoComponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
        // bắt đầu phần DEMO các component
        //-------------  Demo Row - Column  ---------------------------------------------------
        Row {
            Text(text = "Row Text 1", Modifier.background(Color.Red))
            Text(text = "Row Text 2", Modifier.background(Color.White))
            Text(text = "Row Text 3", Modifier.background(Color.Green))
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp)) // tạo đường kẻ ngang
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly) { // thuộc tính căn chỉnh các nội dung
            Text(text = " Text 1")
            Text(text = " Text 2")
            Text(text = " Text 3")
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Column {
            Text(text = "Column Text 1", Modifier.background(Color.Red))
            Text(text = "Column Text 2", Modifier.background(Color.White))
            Text(text = "Column Text 3", Modifier.background(Color.Green))
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        //---------- demo Modifier ------------------
        Text("Text with green background color", Modifier.background(color = Color.Green)   )
        Text(
            "Padding and margin: Dùng 2 lần padding, giữa 2 lần phải cách nhau bằng lời gọi 1 thuộc tính khác",
            Modifier.padding(32.dp) // Padding lần 1 tương ứng margin
                .border( BorderStroke(1.dp, Color.Red))
                .background(color = Color.Green) //Màu nền cho khối
                .padding(16.dp) // padding lần 2 là padding nội dung
                .width(200.dp)
                .height(100.dp)
                
        )
        Text(
            text = "Text with Size",
            color = Color.White,
            modifier = Modifier
                .background(Color.Cyan)
                .border( BorderStroke(1.dp, Color.Red))
                .size(width = 250.dp, height = 100.dp) // định kích cỡ bằng thuộc tính size
        )

        Text(
            text = "Text sử dụng fillMaxWidth",
            color = Color.White,
            modifier = Modifier
                .background(Color.Gray)
                .padding(10.dp)
                .border( BorderStroke(1.dp, Color.Red))
                .fillMaxWidth(0.5f) // 1.0f tương ứng 100%, giá trị nhận từ 0 -> 1, nếu để trống là 100%
                .padding(10.dp)
        )

        Box(Modifier.fillMaxWidth().background(Color.Blue).height(200.dp)){
            Box(
                Modifier .rotate(45f) // xoay lật 45 độ, cái này phải đặt ở trước, đặt cuối nó không xoay
                    .size(100.dp)
                    .alpha(0.2f)//20% opacity - Độ trong suốt của khối
                    .background(Color.Red) // màu đỏ có độ trong suốt nên mới thành màu hồng nhạt
            )
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Ví dụ về weight() thuộc tính giống trong LinearLayout")
        Row() {
            Column(
                Modifier.weight(1f).background(Color.Red)){
                Text(text = "Weight = 1", color = Color.White)
            }
            Column(
                Modifier.weight(1f).background(Color.Blue)){
                Text(text = "Weight = 1", color = Color.White)
            }
            Column(
                Modifier.weight(2f).background(Color.Green)
            ) {
                Text(text = "Weight = 2")
            }
        }
        Text("Ví dụ border".repeat(10),
            Modifier.border(2.dp,
                SolidColor(Color.Blue), //Kiểu đường viền
                RoundedCornerShape(20.dp) // kiểu shape: bo tròn góc
            ))
        Text(
            text = "Ví dụ sử dụng clip() để cắt background",
            color = Color.White,
            modifier = Modifier
                .padding(Dp(10f))
                .clip(RoundedCornerShape(25.dp)) //cắt view
                .background(Color.Blue)
                .padding(Dp(15f))
        )

    }
}

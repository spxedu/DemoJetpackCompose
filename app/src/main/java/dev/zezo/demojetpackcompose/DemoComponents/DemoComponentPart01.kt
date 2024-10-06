package dev.zezo.demojetpackcompose.DemoComponents

import android.os.Bundle
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.zezo.demojetpackcompose.R
import dev.zezo.demojetpackcompose.ui.theme.DemoJetpackComposeTheme

class DemoComponentPart01 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Demo các component",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
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
        //-------------  Demo Text ---------------------------------------------------
        Text("Text với cỡ chữ  30.sp", fontSize = 30.sp, color = Color.Blue) // đơn vị font chữ là: .sp
        Text("Text với chữ đậm FontWeight.Bold", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
        Text("Text tối đa 2 dòng ".repeat(50), maxLines = 2,
            modifier = Modifier.border( BorderStroke(1.dp, Color.Red))
        )
        Text("Text 2 dòng có thêm dấu ba chấm ở cuối ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis,
            modifier = Modifier.border( BorderStroke(1.dp, Color.Blue))
        )
        // thiết lập text có thể sao chép được bằng SelectionContainer
        SelectionContainer (modifier=Modifier.padding(10.dp)) {
            Text("Đoạn text này có thể sao chép được, bấm và giữ vào sẽ hiển thị chọn để copy")
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        //-------------  Demo Button (nút bâm) ---------------------------------------------------
        Button(onClick = {
            //viết code xử lý sự kiện bấm nút tại đây

            Toast.makeText(_context,"Bạn đã bam nut", Toast.LENGTH_LONG).show()

        }) {
            Text(text = "Nút bấm đơn giản mặc định")
        }

        Button(onClick = {
            //your onclick code
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray))
        {
            Text(text = "Đổi màu nền cho nút bấm, màu chữ trắng",color = Color.White)
        }

        Button(onClick = {
                //your onclick code here
        }) {
            Text(text = "Click ", color = Color.Magenta)
            Text(text = "Here", color = Color.Green)
        }
        Button(onClick = {}) {
            Image(
                painterResource(id = R.drawable.ic_launcher_background),
                contentDescription ="Cart button icon",
                modifier = Modifier.size(20.dp))
            Text(text = "Chèn ảnh vào nút bấm",Modifier.padding(start = 10.dp))
        }

        Button(onClick = {}, shape = RectangleShape) {
            Text(text = "Nút bấm hình chữ nhật")
        }
        Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
            Text(text = "Nút bấm bo tròn góc")
        }
        //CutCornerShape(percent: Int)- it will consider as percentage
//CutCornerShape(size: Dp)- you can pass Dp also.
//Here we use Int, so it will take percentage.
        Button(onClick = {}, shape = CutCornerShape(10)) {
            Text(text = "Nút bấm vát góc")
        }

        Button(
            onClick = {
//your onclick code
            },
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text(text = "Khung viền cho nút bấm", color = Color.DarkGray)
        }

        Button(
            onClick = {
//your onclick code here
            }, elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text(text = "Đổ bóng cho nút bấm dùng elevation")
        }
        //-------------  Demo Image  ---------------------------------------------------
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        // chèn ảnh đơn giản
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Flower",
            modifier = Modifier.fillMaxWidth()
        )
        // --- ảnh  tròn
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Circle Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape) // clip to the circle shape
                .border(5.dp, Color.Gray, CircleShape)//optional
        )
        //-- ảnh bo góc
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Round corner image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(10))
                .border(5.dp, Color.Gray, RoundedCornerShape(10))
        )
        //---- thiết lập màu nền cho ảnh 
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_call),
            contentDescription = ""
            ,
            modifier = Modifier
                .size( 200.dp)
                .background(Color.Green)
                .padding(20.dp)
        )
        // --- phủ màu cho ảnh
        Image(
            painter = painterResource(id =  android.R.drawable.ic_menu_call),
            contentDescription = ""
            ,
            colorFilter = ColorFilter.tint(Color.Red),
            modifier = Modifier
                .size( 200.dp)
        )
        //--- scale image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
            ,
            modifier = Modifier
                .size(150.dp)
                .background(Color.LightGray),
            contentScale = ContentScale.Inside
        )

    }// column



}
 //----- Các hàm demo
 @Composable
 fun TextWithSize(label : String, size : TextUnit) {
     Text(label, fontSize = size)
 }
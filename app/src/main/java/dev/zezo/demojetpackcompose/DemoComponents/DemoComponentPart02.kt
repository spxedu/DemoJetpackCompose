package dev.zezo.demojetpackcompose.DemoComponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DemoComponentPart02 : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DemoJetpackComposeTheme {

                //--- dùng cho snackbar
                // Tạo state để điều khiển Snackbar
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope() // Coroutine để hiển thị Snackbar


                Scaffold(modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                    ) { innerPadding ->
                    Greeting2(
                        name = "Demo component phần 2",
                        modifier = Modifier.padding(innerPadding),
                        snackbarHostState=snackbarHostState,scope=scope
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier,
              snackbarHostState:SnackbarHostState,scope: CoroutineScope) {
    val _context = LocalContext.current
    val scrollState = rememberScrollState() // lưu trạng thai cuôn man hinh
    val paddingModifier = Modifier.padding(10.dp)
    // Sử dụng Column để hiển thị các component bằng danh sách dọc
    Text(
        text = " $name!".uppercase(),
//        style = TextStyle(color = MaterialTheme.colorScheme.primary ),
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Column(
        modifier = Modifier
            .padding(10.dp, 50.dp)
            .verticalScroll(scrollState)// cho phep cuon man hinh
    ) {
        // bắt đầu phần DEMO các component
        //-------------  Demo Row - Column  ---------------------------------------------------
        Row {
            Text(text = "Row Text 1", Modifier.background(Color.Red))
            Text(text = "Row Text 2", Modifier.background(Color.White))
            Text(text = "Row Text 3", Modifier.background(Color.Green))
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp)) // tạo đường kẻ ngang
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) { // thuộc tính căn chỉnh các nội dung
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
        Text("Text with green background color", Modifier.background(color = Color.Green))
        Text(
            "Padding and margin: Dùng 2 lần padding, giữa 2 lần phải cách nhau bằng lời gọi 1 thuộc tính khác",
            Modifier
                .padding(32.dp) // Padding lần 1 tương ứng margin
                .border(BorderStroke(1.dp, Color.Red))
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
                .border(BorderStroke(1.dp, Color.Red))
                .size(width = 250.dp, height = 100.dp) // định kích cỡ bằng thuộc tính size
        )

        Text(
            text = "Text sử dụng fillMaxWidth",
            color = Color.White,
            modifier = Modifier
                .background(Color.Gray)
                .padding(10.dp)
                .border(BorderStroke(1.dp, Color.Red))
                .fillMaxWidth(0.5f) // 1.0f tương ứng 100%, giá trị nhận từ 0 -> 1, nếu để trống là 100%
                .padding(10.dp)
        )

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .height(200.dp)) {
            Box(
                Modifier
                    .rotate(45f) // xoay lật 45 độ, cái này phải đặt ở trước, đặt cuối nó không xoay
                    .size(100.dp)
                    .alpha(0.2f)//20% opacity - Độ trong suốt của khối
                    .background(Color.Red) // màu đỏ có độ trong suốt nên mới thành màu hồng nhạt
            )
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Ví dụ về weight() thuộc tính giống trong LinearLayout")
        Row() {
            Column(
                Modifier
                    .weight(1f)
                    .background(Color.Red)
            ) {
                Text(text = "Weight = 1", color = Color.White)
            }
            Column(
                Modifier
                    .weight(1f)
                    .background(Color.Blue)
            ) {
                Text(text = "Weight = 1", color = Color.White)
            }
            Column(
                Modifier
                    .weight(2f)
                    .background(Color.Green)
            ) {
                Text(text = "Weight = 2")
            }
        }
        Text(
            "Ví dụ border".repeat(10),
            Modifier.border(
                2.dp,
                SolidColor(Color.Blue), //Kiểu đường viền
                RoundedCornerShape(20.dp) // kiểu shape: bo tròn góc
            )
        )
        Text(
            text = "Ví dụ sử dụng clip() để cắt background",
            color = Color.White,
            modifier = Modifier
                .padding(Dp(10f))
                .clip(RoundedCornerShape(25.dp)) //cắt view
                .background(Color.Blue)
                .padding(Dp(15f))
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        //---------- demo  Card------------------

        Card() {
            Text(text = "Ví dụ Card đơn giản")
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Card(elevation = CardDefaults.cardElevation(10.dp), modifier = paddingModifier) {
            Text(
                text = "Card với hiệu ứng đổ bóng elevation",
                modifier = paddingModifier
            )
        }

        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = paddingModifier
        ) {
            Text(text = "Round corner shape", modifier = paddingModifier)
        }

        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            border = BorderStroke(1.dp, Color.Blue),
            modifier = paddingModifier
        ) {
            Text(text = "Card with blue border", modifier = paddingModifier)
        }
        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = paddingModifier
        ) {
            Column(modifier = paddingModifier) {
                Text(text = "First Text")
                Text(text = "Second Text")
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        //---------- demo  Chip------------------
        Text("Demo chip: ")
        AssistChip(
            onClick = { Log.d("Assist chip", "hello world") },
            label = { Text("Assist chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
        //------ FilterChip
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            onClick = { selected = !selected },
            label = {
                Text("Filter chip")
            },
            selected = selected,
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )


        //------ InputChip
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        var enabled by remember { mutableStateOf(true) }
        if (!enabled) return
        InputChip(
            onClick = {
                // Viết lệnh khi bấm chọn chip

            },
            label = { Text("Demo InputChip") },
            selected = enabled,
            avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                        .clickable {
                            enabled = !enabled // tắt cái chip 
                        }
                )
            },
        )
        SuggestionChip(
            onClick = { Log.d("Suggestion chip", "hello world") },
            label = { Text("Suggestion chip") }
        )

        //------ demo cho theo option
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        var selectedOption by remember { mutableStateOf("Option 1") }

        Text("Chip da chon: $selectedOption")
        Row {
            FilterChip(
                selected = selectedOption == "Option 1",
                onClick = { selectedOption = "Option 1" },
                label = { Text("Option 1") }
            )
            FilterChip(
                selected = selectedOption == "Option 2",
                onClick = { selectedOption = "Option 2" },
                label = { Text("Option 2") }
            )
        }

        //---------- demo  Switch------------------
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
        //-- switch với thumb tùy chỉnh
         Switch(checked = checked, onCheckedChange = {
            checked = it
        }, thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        })
        // --- thay doi mau sac switch
        Switch(
            checked = checked, onCheckedChange = {
                checked = it
            }, colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )

        //-------------- demo Snackbar -------
        /* Hướng dẫn:
        - Bước 1: Trong phần setContent của hàm onCreate lên trước Scaffold khai báo state để hiển thị snackbar
         // Tạo state để điều khiển Snackbar
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope() // Coroutine để hiển thị Snackbar

        - Bước 2: Trong hàm Scaffold truyền thêm thuộc tính snackbarHost
                snackbarHost = { SnackbarHost(snackbarHostState) }
        - Bước 3: Sửa hàm Greeting... để thêm 2 tham số snackbarHostState và scope
                @Composable
                fun Greeting2(name: String, modifier: Modifier = Modifier,
                            snackbarHostState:SnackbarHostState,scope: CoroutineScope) {....
        - Bước 4: Ở hàm onCreate chỗ gọi hàm Greeting thì truyền vào 2 tham số trên
                Greeting2(
                        name = "Demo component phần 2",
                        modifier = Modifier.padding(innerPadding),
                        snackbarHostState=snackbarHostState,scope=scope //cần 2 tham số này cho snackbar
                    )
        - Bước 5: Ở trong hàm Greeting khai báo nút bấm để hiển thị snackbar

        */
    
        // Nút để kích hoạt Snackbar
        Button(onClick = {
            // Hiển thị Snackbar khi nhấn nút
            scope.launch {
               var result =  snackbarHostState.showSnackbar(
                    message = "Đây là nội dung hiển thị trên snackbar, xem logcat",
                    actionLabel = "Đây là text hành động, bấm vào",
                   duration = SnackbarDuration.Short // thiết lập thời gian tự tắt
               )

                // Xử lý click vào action
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    // Người dùng đã nhấn vào "Undo"
                    // Xử lý việc hoàn tác (Undo) ở đây
                    println("Người dùng đã bấm vào action, xem logcat nhé ")
                }
                SnackbarResult.Dismissed -> {
                    // Snackbar tự động bị tắt hoặc người dùng bỏ qua
                    println("Snackbar tự tắt, người dùng không bấm, xem logcat")
                }
            }

            }
        }) {
            Text("Show Snackbar")
        }




    }
}

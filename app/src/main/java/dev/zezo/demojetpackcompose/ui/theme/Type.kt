package dev.zezo.demojetpackcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

//Hiểu về typography tham khảo tại https://m2.material.io/design/typography/the-type-system.html#type-scale 

// Danh sách các mẫu phải sử dụng theo tên đã có của Material
//val displayLarge: TextStyle = TypographyTokens. DisplayLarge,
//val displayMedium: TextStyle = TypographyTokens. DisplayMedium,
//val displaySmall: TextStyle = TypographyTokens. DisplaySmall,
//val headlineLarge: TextStyle = TypographyTokens. HeadlineLarge,
//val headlineMedium: TextStyle = TypographyTokens. HeadlineMedium,
//val headlineSmall: TextStyle = TypographyTokens. HeadlineSmall,
//val titleLarge: TextStyle = TypographyTokens. TitleLarge,
//val titleMedium: TextStyle = TypographyTokens. TitleMedium,
//val titleSmall: TextStyle = TypographyTokens. TitleSmall,
//val bodyLarge: TextStyle = TypographyTokens. BodyLarge,
//val bodyMedium: TextStyle = TypographyTokens. BodyMedium,
//val bodySmall: TextStyle = TypographyTokens. BodySmall,
//val labelLarge: TextStyle = TypographyTokens. LabelLarge,
//val labelMedium: TextStyle = TypographyTokens. LabelMedium,
//val labelSmall: TextStyle = TypographyTokens. LabelSmall

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = mau_so_1
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
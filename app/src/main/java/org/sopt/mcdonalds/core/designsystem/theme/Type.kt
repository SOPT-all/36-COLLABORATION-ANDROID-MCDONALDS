package org.sopt.mcdonalds.core.designsystem.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.mcdonalds.R

val PretendardBold = FontFamily(Font(R.font.pretendard_bold))
val PretendardSemiBold = FontFamily(Font(R.font.pretendard_semibold))
val PretendardMedium = FontFamily(Font(R.font.pretendard_medium))
val PretendardRegular = FontFamily(Font(R.font.pretendard_regular))

@Immutable
class McDonaldsTypography(
    val head34b: TextStyle,
    val head24sb: TextStyle,
    val head18b: TextStyle,
    val body18m: TextStyle,
    val body16sb: TextStyle,
    val body16m: TextStyle,
    val body16r: TextStyle,
    val body14b: TextStyle,
    val body14m: TextStyle,
    val body14r: TextStyle,
    val body12m: TextStyle,
    val body12r: TextStyle,
    val caption10r: TextStyle
)

private fun McDonaldsTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = 1.4.em
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

fun McDonaldsTypography() = McDonaldsTypography(
    head34b = McDonaldsTextStyle(
        fontFamily = PretendardBold,
        fontSize = 34.sp,
        lineHeight = 40.sp
    ),
    head24sb = McDonaldsTextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 24.sp,
        lineHeight = 22.sp
    ),
    head18b = McDonaldsTextStyle(
        fontFamily = PretendardBold,
        fontSize = 18.sp
    ),
    body18m = McDonaldsTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 18.sp,
        lineHeight = 22.sp
    ),
    body16sb = McDonaldsTextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 16.sp,
    ),
    body16m = McDonaldsTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 16.sp,
    ),
    body16r = McDonaldsTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 16.sp,
        lineHeight = 22.sp,
    ),
    body14b = McDonaldsTextStyle(
        fontFamily = PretendardBold,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
    body14m = McDonaldsTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),
    body14r = McDonaldsTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 14.sp
    ),
    body12m = McDonaldsTextStyle(
        fontFamily = PretendardMedium,
        fontSize = 12.sp,
        lineHeight = 22.sp,
    ),
    body12r = McDonaldsTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 12.sp,
        lineHeight = 22.sp
    ),
    caption10r = McDonaldsTextStyle(
        fontFamily = PretendardRegular,
        fontSize = 10.sp,
        lineHeight = 22.sp
    )
)

@Preview(showBackground = true)
@Composable
fun McDonaldsTypographyPreview() {
    MCDONALDSTheme {
        Column {
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.head34b
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.head24sb
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.head18b
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body18m
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body16sb
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body16m
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body16r
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body14b
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body14m
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body14r
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body12m
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.body12r
            )
            Text(
                "McdonaldsTheme",
                style = McDonaldsTheme.typography.caption10r
            )
        }
    }
}

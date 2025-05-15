package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.core.common.util.NoRippleInteractionSource
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

@Composable
fun HistoryStoreChangeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = BorderStroke(0.5.dp, McDonaldsTheme.colors.blue),
        colors = ButtonDefaults.buttonColors(McDonaldsTheme.colors.white),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp),
        interactionSource = NoRippleInteractionSource,
    ) {
        Text(
            text = text,
            style = McDonaldsTheme.typography.caption10r,
            color = McDonaldsTheme.colors.blue,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun HistoryStoreChangeButtonPreview(
){
    MCDONALDSTheme {
        HistoryStoreChangeButton(
            text = "매장 변경",
            onClick = {},
            modifier = Modifier.size(width = 61.dp, height = 29.dp),
            enabled = true,
        )
    }
}
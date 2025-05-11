package org.sopt.mcdonalds.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalMcDonaldsColors = staticCompositionLocalOf<McDonaldsColors> {
    error("No McDonaldsColors provided")
}

private val LocalMcDonaldsTypography = staticCompositionLocalOf<McDonaldsTypography> {
    error("No McDonaldsTypography provided")
}

object McDonaldsTheme {
    val colors: McDonaldsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMcDonaldsColors.current
    val typography: McDonaldsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMcDonaldsTypography.current
}

@Composable
fun ProvideMcDonaldsColorsAndTypography(
    colors: McDonaldsColors,
    typography: McDonaldsTypography,
    content: @Composable () -> Unit
) {
    val provideColors = remember { colors.copy() }.apply { update(colors) }
    CompositionLocalProvider(
        LocalMcDonaldsColors provides provideColors,
        LocalMcDonaldsTypography provides typography,
        content = content
    )
}

@Composable
fun MCDONALDSTheme(
    content: @Composable () -> Unit
) {
    val colors = McDonaldsLightColors()
    val typography = McDonaldsTypography()

    ProvideMcDonaldsColorsAndTypography(
        colors = colors,
        typography = typography
    ) {
        MaterialTheme(
            content = content
        )
    }
}

package pt.iade.faztudo.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = Color.White,
    primaryContainer = PrimaryBlueLight,
    onPrimaryContainer = Color.White,
    secondary = TextGray,
    onSecondary = Color.White,
    secondaryContainer = SecondaryGray,
    onSecondaryContainer = TextDark,
    tertiary = SuccessGreen,
    onTertiary = Color.White,
    background = BackgroundWhite,
    onBackground = TextDark,
    surface = CardBackground,
    onSurface = TextDark,
    surfaceVariant = SurfaceGray,
    onSurfaceVariant = TextGray,
    error = ErrorRed,
    onError = Color.White,
    outline = DividerGray,
    outlineVariant = DividerGray
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlueLight,
    onPrimary = Color.White,
    primaryContainer = PrimaryBlue,
    onPrimaryContainer = Color.White,
    secondary = TextLight,
    onSecondary = TextDark,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    error = ErrorRed,
    onError = Color.White
)

@Composable
fun FazTudoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

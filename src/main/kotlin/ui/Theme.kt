package ui

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import model.data.Attribute
import model.data.Essence


private val LightColors = lightColorScheme(
  primary = md_theme_light_primary,
  onPrimary = md_theme_light_onPrimary,
  primaryContainer = md_theme_light_primaryContainer,
  onPrimaryContainer = md_theme_light_onPrimaryContainer,
  secondary = md_theme_light_secondary,
  onSecondary = md_theme_light_onSecondary,
  secondaryContainer = md_theme_light_secondaryContainer,
  onSecondaryContainer = md_theme_light_onSecondaryContainer,
  tertiary = md_theme_light_tertiary,
  onTertiary = md_theme_light_onTertiary,
  tertiaryContainer = md_theme_light_tertiaryContainer,
  onTertiaryContainer = md_theme_light_onTertiaryContainer,
  error = md_theme_light_error,
  errorContainer = md_theme_light_errorContainer,
  onError = md_theme_light_onError,
  onErrorContainer = md_theme_light_onErrorContainer,
  background = md_theme_light_background,
  onBackground = md_theme_light_onBackground,
  surface = md_theme_light_surface,
  onSurface = md_theme_light_onSurface,
  surfaceVariant = md_theme_light_surfaceVariant,
  onSurfaceVariant = md_theme_light_onSurfaceVariant,
  outline = md_theme_light_outline,
  inverseOnSurface = md_theme_light_inverseOnSurface,
  inverseSurface = md_theme_light_inverseSurface,
  inversePrimary = md_theme_light_inversePrimary,
  surfaceTint = md_theme_light_surfaceTint,
  outlineVariant = md_theme_light_outlineVariant,
  scrim = md_theme_light_scrim,
)


private val DarkColors = darkColorScheme(
  primary = md_theme_dark_primary,
  onPrimary = md_theme_dark_onPrimary,
  primaryContainer = md_theme_dark_primaryContainer,
  onPrimaryContainer = md_theme_dark_onPrimaryContainer,
  secondary = md_theme_dark_secondary,
  onSecondary = md_theme_dark_onSecondary,
  secondaryContainer = md_theme_dark_secondaryContainer,
  onSecondaryContainer = md_theme_dark_onSecondaryContainer,
  tertiary = md_theme_dark_tertiary,
  onTertiary = md_theme_dark_onTertiary,
  tertiaryContainer = md_theme_dark_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_onTertiaryContainer,
  error = md_theme_dark_error,
  errorContainer = md_theme_dark_errorContainer,
  onError = md_theme_dark_onError,
  onErrorContainer = md_theme_dark_onErrorContainer,
  background = md_theme_dark_background,
  onBackground = md_theme_dark_onBackground,
  surface = md_theme_dark_surface,
  onSurface = md_theme_dark_onSurface,
  surfaceVariant = md_theme_dark_surfaceVariant,
  onSurfaceVariant = md_theme_dark_onSurfaceVariant,
  outline = md_theme_dark_outline,
  inverseOnSurface = md_theme_dark_inverseOnSurface,
  inverseSurface = md_theme_dark_inverseSurface,
  inversePrimary = md_theme_dark_inversePrimary,
  surfaceTint = md_theme_dark_surfaceTint,
  outlineVariant = md_theme_dark_outlineVariant,
  scrim = md_theme_dark_scrim,
)

data class AttributeTheme(
  val primary: Color,
  val onPrimary: Color,
  val surfaceTint: Color,
  val surfaceVariant: Color,
)

val yellowAttributeTheme = AttributeTheme(
  primary = dark_CustomColor1,
  onPrimary = dark_onCustomColor1,
  surfaceTint = dark_CustomColor1,
  surfaceVariant = dark_CustomColor1Container,
)

val cyanAttributeTheme = AttributeTheme(
  primary = dark_CustomColor2,
  onPrimary = dark_onCustomColor2,
  surfaceTint = dark_CustomColor2,
  surfaceVariant = dark_CustomColor2Container,
)

val redAttributeTheme = AttributeTheme(
  primary = dark_CustomColor3,
  onPrimary = dark_onCustomColor3,
  surfaceTint = dark_CustomColor3,
  surfaceVariant = dark_CustomColor3Container,
)

val grayAttributeTheme = AttributeTheme(
  primary = Color.Gray,
  onPrimary = Color.LightGray,
  surfaceTint = Color.White,
  surfaceVariant = Color.DarkGray,
)

@Composable
fun noAttributeTheme() = AttributeTheme(
  primary = MaterialTheme.colorScheme.primary,
  onPrimary = MaterialTheme.colorScheme.onPrimary,
  surfaceTint = MaterialTheme.colorScheme.surfaceTint,
  surfaceVariant = MaterialTheme.colorScheme.surfaceVariant,
)

@Composable
fun Attribute?.getTheme(): AttributeTheme = when (this) {
  is Attribute.Diplomacy -> cyanAttributeTheme
  is Attribute.Military -> redAttributeTheme
  is Attribute.Technology -> grayAttributeTheme
  is Attribute.Economic -> yellowAttributeTheme
  null -> noAttributeTheme()
}

fun Essence.getColor(): Color = when (this.attribute) {
  is Attribute.Diplomacy -> dark_CustomColor2
  is Attribute.Military -> dark_CustomColor3
  is Attribute.Technology -> Color.Gray
  is Attribute.Economic -> dark_CustomColor1
}

@Composable
fun CardTheme(
  attributeTheme: AttributeTheme,
  content: @Composable () -> Unit
) {
  MaterialTheme(
    colorScheme = DarkColors.copy(
      primary = attributeTheme.primary,
      onPrimary = attributeTheme.onPrimary,
      surfaceTint = attributeTheme.surfaceTint,
      surface = true_dark_surface,
      onSurface = true_dark_onSurface,
      surfaceVariant = attributeTheme.surfaceVariant
    )
  ) {
//    ProvideCardTextStyle {
      content()
//    }
  }
}

@Composable
fun ProvideCardDimension(
  cardDimension: CardDimension,
  content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    LocalCardDimension provides cardDimension,
    LocalTextStyle provides MaterialTheme.typography.bodySmall.copy(fontSize = cardDimension.fontSize)
  ) {
    content()
  }
}

@Composable
fun ProvideCardTextStyle(content: @Composable () -> Unit) {
  val cardDimension = LocalCardDimension.current
  CompositionLocalProvider(
    LocalTextStyle provides MaterialTheme.typography.bodySmall.copy(fontSize = cardDimension.fontSize)
  ) {
    content()
  }
}

@Composable
fun AppTheme(
  useDarkTheme: Boolean = true, // ,isSystemInDarkTheme(),
  content: @Composable() () -> Unit
) {
  val colors = if (!useDarkTheme) {
    LightColors
  } else {
    DarkColors
  }

  MaterialTheme(
    colorScheme = colors,
    content = content
  )
}
package com.example.jetmusicplayer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//@Preview(showBackground = true)
@Composable
fun MusicButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String,
    background: Color=MaterialTheme.colorScheme.background ,
    tint: Color=MaterialTheme.colorScheme.onBackground,
    onClick: () -> Unit = {},
    elevation: Dp =0.dp,
    size: Dp=40.dp
) {
    Surface(
        modifier = modifier.size(size),
        color = background,
        shape = CircleShape,
        shadowElevation = elevation
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = tint,
            modifier = Modifier.clickable {
                onClick()
            }
        )

    }
}

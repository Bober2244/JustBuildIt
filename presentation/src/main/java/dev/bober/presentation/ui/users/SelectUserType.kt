package dev.bober.presentation.ui.users

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectUserType(
    modifier: Modifier = Modifier,
    onUserTypeClick: () -> Unit,
) {
    val userTypes = listOf("Администратор", "Заказчик")

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Расскажите нам кто вы \uD83E\uDD14",
            fontSize = 48.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 5,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        userTypes.forEach {
            Surface (
                modifier = Modifier.clickable { onUserTypeClick() },
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                color = Color.Transparent,
                shape = RoundedCornerShape(4.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = it,
                        fontSize = 40.sp,
                    )
                }

            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Preview(showBackground = true, heightDp = 700, widthDp = 350)
@Composable
private fun SelectUserTypePreview() {
    SelectUserType(
        onUserTypeClick = {},
    )
}
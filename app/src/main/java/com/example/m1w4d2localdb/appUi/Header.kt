@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.m1w4d2localdb.appUi

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import com.example.m1w4d2localdb.R

@Composable
fun Header (
        isDark: MutableState<Boolean>,
        title: String
){
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                MaterialTheme.colorScheme.primaryContainer,
            ),
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontFamily = FontFamily.Serif,
                    fontWeight = SemiBold
                )
            },

            //menu icon at the beginning of the bar
            navigationIcon = {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "menu icon",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(32.dp)
                        .height(32.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            },

            actions = {
                //dark & light themes switcher icon at the end of the bar
                // dark mode icon before the end of the bar
//            var isDark by remember { mutableStateOf(false) }
                Button(
                    onClick = { isDark.value = !isDark.value },
                    modifier = Modifier.padding(0.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)

                ) {
                    val screenModeIcon = if (isDark.value) R.drawable.sun else R.drawable.moon
                    Icon(
                        painter = painterResource(id = screenModeIcon),
                        contentDescription = "search icon",
                        modifier = Modifier
                            .padding(0.dp)
                            .size(28.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        )
    }

package com.example.bible_app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuItemColors
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFA6DCE0))) {
        Text(
            text = "BIBLE Search",
            fontSize = 45.sp, fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all = 15.dp), color = Color(0xFF41526C)
        )
        var mExpanded by remember { mutableStateOf(false) }

        // Create a list of cities
        val menu = listOf<String>("old Testament" , "new Testament")

        // Create a string value to store the selected city
        var mSelectedText by remember { mutableStateOf("") }

        var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

        // Up Icon when expanded and down icon when collapsed
        val icon = if (mExpanded) {
            Icons.Filled.KeyboardArrowUp
        }
        else {
            Icons.Filled.KeyboardArrowDown
        }
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            menu.forEach { label ->
                DropdownMenuItem(text = {label}, onClick = {
                    mSelectedText = label
                    mExpanded = false
                })
            }
        }
    }
}
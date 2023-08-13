package com.gamingpine.todonotes.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gamingpine.todonotes.ui.theme.BabyBlue
import com.gamingpine.todonotes.ui.theme.LightGreen
import com.gamingpine.todonotes.ui.theme.RedOrange
import com.gamingpine.todonotes.ui.theme.RedPink
import com.gamingpine.todonotes.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val description: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors: List<Color> = listOf(RedOrange, RedPink, BabyBlue, Violet, LightGreen)
    }
}

class InvalidNoteException(private val msg: String): Exception(msg)

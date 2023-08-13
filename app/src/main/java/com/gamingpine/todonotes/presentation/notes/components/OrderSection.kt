package com.gamingpine.todonotes.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gamingpine.todonotes.domain.util.NoteOrder
import com.gamingpine.todonotes.domain.util.OrderType

/**
 * Created by muhammadibrahim on 13/08/2023
 *
 * Desc: Composable for order section group of radio buttons
 */


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.DESCENDING),
    onOrderChange: (NoteOrder) -> Unit
) {

    Column(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            DefaultRadioButton(
                title = "Title",
                selected = noteOrder is NoteOrder.Title,
                onSelection = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                title = "Date",
                selected = noteOrder is NoteOrder.Date,
                onSelection = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                title = "Color",
                selected = noteOrder is NoteOrder.Color,
                onSelection = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                title = "Ascending",
                selected = noteOrder.orderType == OrderType.ASCENDING,
                onSelection = { onOrderChange(noteOrder.copy(OrderType.ASCENDING)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                title = "Descending",
                selected = noteOrder.orderType == OrderType.DESCENDING,
                onSelection = { onOrderChange(noteOrder.copy(OrderType.DESCENDING)) }
            )
        }

    }

}

package com.gamingpine.todonotes.domain.util

/**
 * Created by muhammadibrahim on 12/08/2023
 *
 * Desc: to decide the order of notes list based on title, date and color
 */
sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)

    fun copy(orderType: OrderType) = when (this) {
        is Title -> Title(orderType)
        is Date -> Date(orderType)
        is Color -> Color(orderType)
    }
}

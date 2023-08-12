package com.gamingpine.todonotes.presentation.notes

import androidx.lifecycle.ViewModel
import com.gamingpine.todonotes.domain.usecase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by muhammadibrahim on 12/08/2023
 *
 * Desc: Viewmodel class for displaying notes
 */

@HiltViewModel
class NotesViewModel @Inject constructor(private val useCases: NoteUseCases) : ViewModel() {

}
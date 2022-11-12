package com.github.kontvip.lab3.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.kontvip.lab3.domain.DogFactInteractor
import com.github.kontvip.lab3.domain.model.Fact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val interactor: DogFactInteractor
) : ViewModel() {

    fun getDogFact(onGetFact: (Fact) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            onGetFact.invoke(interactor.getDogFact())
        }
    }

}
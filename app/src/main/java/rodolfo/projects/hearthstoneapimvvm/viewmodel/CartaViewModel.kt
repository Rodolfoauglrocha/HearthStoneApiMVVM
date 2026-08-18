package rodolfo.projects.hearthstoneapimvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rodolfo.projects.hearthstoneapimvvm.model.Carta
import rodolfo.projects.hearthstoneapimvvm.repository.CartaRepository
import javax.inject.Inject

@HiltViewModel
class CartaViewModel @Inject constructor(
    private val repository : CartaRepository
): ViewModel() {

    private val _cartas = MutableLiveData<List<Carta>>()

    val cartas : LiveData<List<Carta>> = _cartas

    fun recuperarCartas() {
        viewModelScope.launch {
            val listaCartas = repository.recuperarCartas()
            _cartas.postValue(listaCartas)
        }
    }
}
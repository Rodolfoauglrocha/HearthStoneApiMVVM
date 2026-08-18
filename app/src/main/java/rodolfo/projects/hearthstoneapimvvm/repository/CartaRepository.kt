package rodolfo.projects.hearthstoneapimvvm.repository

import rodolfo.projects.hearthstoneapimvvm.api.ApiService
import rodolfo.projects.hearthstoneapimvvm.model.Carta
import javax.inject.Inject

class CartaRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun recuperarCartas(): List<Carta> {
        return api.recuperarCartas()
    }
}
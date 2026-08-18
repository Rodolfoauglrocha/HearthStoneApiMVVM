package rodolfo.projects.hearthstoneapimvvm.api

import retrofit2.http.GET
import rodolfo.projects.hearthstoneapimvvm.model.Carta

interface ApiService {

    @GET("cards.json")
    suspend fun recuperarCartas() : List<Carta>
}
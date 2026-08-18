package rodolfo.projects.hearthstoneapimvvm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Carta(
    val id: String = "",
    val name: String = "",
    val type: String = "",
    val rarity: String? = null,
    val cost: Int? = null
) : Parcelable
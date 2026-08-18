package rodolfo.projects.hearthstoneapimvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rodolfo.projects.hearthstoneapimvvm.databinding.ItemCartaBinding
import rodolfo.projects.hearthstoneapimvvm.model.Carta
import com.squareup.picasso.Picasso

class CartaAdapter(
    private var listaCartas: List<Carta>,
    private val onClick: (Carta) -> Unit
) : RecyclerView.Adapter<CartaAdapter.CartaViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartaViewHolder {

        val binding = ItemCartaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CartaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CartaViewHolder,
        position: Int
    ) {
        val carta = listaCartas[position]

        holder.binding.textNome.text = carta.name
        holder.binding.textTipo.text = "Tipo: ${carta.type}"
        holder.binding.textRaridade.text = "Raridade: ${carta.rarity}"
        holder.binding.textMana.text = "Mana: ${carta.cost}"

        val urlImagem =
            "https://art.hearthstonejson.com/v1/render/latest/ptBR/256x/${carta.id}.png"

        Picasso.get()
            .load(urlImagem)
            .into(holder.binding.imageCarta)

        holder.binding.root.setOnClickListener {
            onClick(carta)
        }
    }

    override fun getItemCount(): Int {
        return listaCartas.size
    }

    fun atualizarLista(novaLista: List<Carta>) {
        listaCartas = novaLista
        notifyDataSetChanged()
    }

    inner class CartaViewHolder(
        val binding: ItemCartaBinding
    ) : RecyclerView.ViewHolder(binding.root)

}

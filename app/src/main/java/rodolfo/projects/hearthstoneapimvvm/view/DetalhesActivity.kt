package rodolfo.projects.hearthstoneapimvvm.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.squareup.picasso.Picasso
import rodolfo.projects.hearthstoneapimvvm.R
import rodolfo.projects.hearthstoneapimvvm.databinding.ActivityDetalhesBinding
import rodolfo.projects.hearthstoneapimvvm.model.Carta

class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.statusBars())
            systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }


        val carta = intent.getParcelableExtra<Carta>("carta")

        binding.textNome.text = carta?.name
        binding.textTipo.text = "Tipo: ${carta?.type}"
        binding.textRaridade.text = "Raridade: ${carta?.rarity}"
        binding.textMana.text = "Mana: ${carta?.cost}"

        val urlImagem =
            "https://art.hearthstonejson.com/v1/render/latest/ptBR/256x/${carta?.id}.png"

        Picasso.get()
            .load(urlImagem)
            .into(binding.imageCarta)
    }
}
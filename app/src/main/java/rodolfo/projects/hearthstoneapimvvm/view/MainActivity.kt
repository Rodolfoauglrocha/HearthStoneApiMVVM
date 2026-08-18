package rodolfo.projects.hearthstoneapimvvm.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import rodolfo.projects.hearthstoneapimvvm.adapter.CartaAdapter
import rodolfo.projects.hearthstoneapimvvm.databinding.ActivityMainBinding
import rodolfo.projects.hearthstoneapimvvm.viewmodel.CartaViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: CartaViewModel by viewModels()
    private lateinit var cartaAdapter : CartaAdapter

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

        //viewModel = ViewModelProvider(this)[CartaViewModel::class.java]

        cartaAdapter = CartaAdapter(emptyList()) { carta ->
           val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("carta", carta)
            startActivity(intent)
        }
        binding.recyclerCartas.layoutManager = LinearLayoutManager(this)
        binding.recyclerCartas.adapter = cartaAdapter

        viewModel.cartas.observe(this){listaCartas ->

            cartaAdapter.atualizarLista(listaCartas)
        }

        viewModel.recuperarCartas()
    }
}
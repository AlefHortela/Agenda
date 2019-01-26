package alef.br.agenda

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import kotlinx.android.synthetic.main.activity_lista_contatos.*;
import android.view.Menu;
import android.graphics.Color;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;


class ListaContatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contatos);

        val myToolbar = toolbar
        myToolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(myToolbar)

        val contatos = arrayOf("Maria", "José", "Carlos")
        val adapter
                = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                contatos)
        var listaContatos = lista;
        listaContatos.setAdapter(adapter);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.novo -> {
                val intent = Intent(this, ContatoActivity::class.java)
                startActivity(intent)
                return false
            }
            R.id.sincronizar -> {
                Toast.makeText(this, "Enviar", Toast.LENGTH_LONG).show()
                return false
            }
            R.id.receber -> {
                Toast.makeText(this, "Receber", Toast.LENGTH_LONG).show()
                return false
            }
            R.id.mapa -> {
                Toast.makeText(this, "Mapa", Toast.LENGTH_LONG).show()
                return false
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}

package alef.br.agenda

import alef.br.db.Contato
import alef.br.db.ContatoRepository
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import android.app.DatePickerDialog
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_contato.*
import java.util.*
import android.widget.EditText
import android.widget.ImageView



import kotlinx.android.synthetic.main.activity_contato.*

class ContatoActivity : AppCompatActivity() {

    var cal = Calendar.getInstance()
    var datanascimento: Button? = null;

    private var contato: ImageView? = null
    private var nome: EditText? = null
    private var endereco: EditText? = null
    private var telefone: EditText? = null
    private var site: EditText? = null
    private var cadastro: Button? = null
    private var email: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
        val myChildToolbar = toolbar_child
        setSupportActionBar(myChildToolbar)
        val ab = supportActionBar
        ab!!.setDisplayHomeAsUpEnabled(true)
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
        datanascimento = txtDatanascimento
        datanascimento!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@ContatoActivity,
                        dateSetListener,
                        // set DatePickerDialog to point to today's date when it loads up
                                cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        contato = imgContato
        nome = txtNome
        endereco = txtEndereco
        telefone = txtTelefone
        site = txtSite
        email = txtEmail
        cadastro = btnCadastro

        btnCadastro?.setOnClickListener {
            val contato = Contato(
                    0,
                    null,
                    txtNome?.text.toString(),
                    txtEndereco?.text.toString(),
                    txtTelefone?.text.toString().toLong(),
                    cal.timeInMillis,
                    txtEmail?.text.toString(),
                    txtSite?.text.toString())
            ContatoRepository(this).create(contato)
            finish()
        }

    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        datanascimento!!.text = sdf.format(cal.getTime())
    }

}

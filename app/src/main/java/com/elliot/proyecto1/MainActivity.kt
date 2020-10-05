package com.elliot.proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var textNombre: TextView
    private lateinit var textTelefono: TextView
    private lateinit var textCorreo: TextView
    private lateinit var textPlan: TextView
    private lateinit var textCategoria: TextView
    private lateinit var editNombre: EditText
    private lateinit var editTelefono: EditText
    private lateinit var editCorreo: EditText
    private lateinit var checkRomantico: CheckBox
    private lateinit var checkTerror: CheckBox
    private lateinit var checkComedia: CheckBox
    private lateinit var checkAnime: CheckBox
    private lateinit var checkAccion: CheckBox
    private lateinit var radioBasico: RadioButton
    private lateinit var radioEstandar: RadioButton
    private lateinit var radioPremium: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        checkRomantico = findViewById<CheckBox>(R.id.checkRomantica)
        checkTerror = findViewById<CheckBox>(R.id.checkTerror)
        checkComedia = findViewById<CheckBox>(R.id.checkComedia)
        checkAnime = findViewById<CheckBox>(R.id.checkAnime)
        checkAccion = findViewById<CheckBox>(R.id.checkAccion)

        textNombre = findViewById<TextView>(R.id.textNombre)
        textTelefono = findViewById<TextView>(R.id.textTelefono)
        textCorreo = findViewById<TextView>(R.id.textCorreo)
        textPlan = findViewById<TextView>(R.id.textPlan)
        textCategoria = findViewById<TextView>(R.id.textCategoria)

        editNombre = findViewById<EditText>(R.id.editNombre)
        editTelefono = findViewById<EditText>(R.id.editTelefono)
        editCorreo = findViewById<EditText>(R.id.editCorreo)

        radioBasico = findViewById<RadioButton>(R.id.radioBasico)
        radioEstandar = findViewById<RadioButton>(R.id.radioEstandar)
        radioPremium = findViewById<RadioButton>(R.id.radioPremium)

        checkRomantico.setOnCheckedChangeListener(changeChecked)
        checkTerror.setOnCheckedChangeListener(changeChecked)
        checkComedia.setOnCheckedChangeListener(changeChecked)
        checkAnime.setOnCheckedChangeListener(changeChecked)
        checkAccion.setOnCheckedChangeListener(changeChecked)

        val fabActionDialog = findViewById<FloatingActionButton>(R.id.fabActionDialog)
        fabActionDialog.setOnClickListener(fabClick)
    }

    private val fabClick = View.OnClickListener { fab ->
        var textoRadio = ""
        if (radioBasico.isChecked) {
            textoRadio = radioBasico.text.toString() + "\n"
        } else if (radioEstandar.isChecked) {
            textoRadio = radioEstandar.text.toString() + "\n"
        } else if (radioPremium.isChecked) {
            textoRadio = radioBasico.text.toString() + "\n"
        }
        var textoCategoria = ""
        if (checkRomantico.isChecked) {
            textoCategoria += checkRomantico.text.toString()+"\n"
        }
        if (checkTerror.isChecked) {
            textoCategoria += checkTerror.text.toString()+"\n"
        }
        if (checkComedia.isChecked) {
            textoCategoria += checkComedia.text.toString()+"\n"
        }
        if (checkAnime.isChecked) {
            textoCategoria += checkAnime.text.toString()+"\n"
        }
        if (checkAccion.isChecked) {
            textoCategoria += checkAccion.text.toString()+"\n"
        }
        val alertDialog = AlertDialog.Builder(fab.context)
                .setTitle("Informacion de usuario")
                .setMessage(
                    textNombre.text.toString() + "\n" + editNombre.text
                            + "\n\n" + textTelefono.text.toString() + "\n" + editTelefono.text
                            + "\n\n" + textCorreo.text.toString() + "\n" + editCorreo.text
                            + "\n\n" + textPlan.text.toString() + "\n" + textoRadio
                            + "\n\n" + textCategoria.text.toString() + "\n" + textoCategoria
                )
                .create()

            alertDialog.show()
        }


        private val changeChecked = CompoundButton.OnCheckedChangeListener { button, checked ->
            val categorias = mutableListOf<Categoria>()
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            val categoriaAdapter = CategoriaAdapter(categorias)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = categoriaAdapter


            if (checkRomantico.isChecked) {
                categorias.add(
                    Categoria(
                        " Romantica",
                        R.drawable.ic_romantico
                    )
                )
                categoriaAdapter.notifyDataSetChanged()
            }

            if (checkTerror.isChecked) {
                categorias.add(
                    Categoria(
                        " Terror",
                        R.drawable.ic_terror
                    )
                )
                categoriaAdapter.notifyDataSetChanged()
            }

            if (checkComedia.isChecked) {
                categorias.add(
                    Categoria(
                        " Comedia",
                        R.drawable.ic_comedia
                    )
                )
                categoriaAdapter.notifyDataSetChanged()
            }

            if (checkAnime.isChecked) {
                categorias.add(
                    Categoria(
                        " Anime",
                        R.drawable.ic_anime
                    )
                )
                categoriaAdapter.notifyDataSetChanged()
            }

            if (checkAccion.isChecked) {
                categorias.add(
                    Categoria(
                        " Accion",
                        R.drawable.ic_accion
                    )
                )
                categoriaAdapter.notifyDataSetChanged()
            }
        }
    }


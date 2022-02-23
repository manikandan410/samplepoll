package com.example.poll


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.core.view.get
import com.google.android.material.textfield.TextInputLayout

class Head : AppCompatActivity() {

    private lateinit var selectlanguage: AutoCompleteTextView
    private lateinit var languagetext: TextInputLayout
    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    /*    val language = resources.getStringArray(R.array.languages)
        adapter = ArrayAdapter(applicationContext,android.R.layout.simple_dropdown_item_1line,language)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
    languagetext = findViewById(R.id.dropdown_result) as TextInputLayout
      // AutoCompleteTextView
        //selectlanguage.adapter=adapter*/


        selectlanguage = findViewById(R.id.autoCompleteTextLanguage)!!
        languagetext = findViewById(R.id.dropdown_result)

        val arrayAdapter : ArrayAdapter<*>
        var data= arrayListOf<String>("English","தமிழ","हिन्द")
        arrayAdapter = ArrayAdapter(this@Head,R.layout.items_list,data)
        selectlanguage.setAdapter(arrayAdapter)



    }
}
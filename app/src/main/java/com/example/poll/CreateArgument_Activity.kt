package com.example.poll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.poll.databinding.ActivityCreateArgumentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class CreateArgument_Activity : AppCompatActivity() {
    lateinit var registerBtn: Button
    lateinit var editText: EditText
    lateinit var spinner: Spinner
    lateinit var adapter: ArrayAdapter<String>
    lateinit var spinner1: Spinner
    private lateinit var databaseReference: DatabaseReference
    private lateinit var binding: ActivityCreateArgumentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateArgumentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.registerBtn.setOnClickListener {
            val creatrTitle = binding.editText.text.toString()
            val language = binding.spinner.dropDownVerticalOffset.toString()
            val handrise = binding.spinner1.dropDownVerticalOffset.toString()

            val User = User(creatrTitle,language,handrise)
                databaseReference.child(creatrTitle).setValue(User).addOnCompleteListener {
                    binding.editText.text.clear()
                    //Toast.makeText(this, "successfully create", Toast.LENGTH_SHORT).show()
            }

    }
        val data = arrayListOf<String>("English", "தமிழ", "हिन्द")
        adapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter


        val data1 = arrayListOf<String>("Open to Everyone", "Follower Only", "Off")
        adapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, data1)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner = findViewById(R.id.spinner1)
        spinner.adapter = adapter

              }
    }

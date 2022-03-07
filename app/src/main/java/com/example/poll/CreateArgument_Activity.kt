package com.example.poll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poll.databinding.ActivityCreateArgumentBinding
import com.google.firebase.database.*

class CreateArgument_Activity : AppCompatActivity() {

    private lateinit var binding :ActivityCreateArgumentBinding
    private lateinit var database : DatabaseReference
    lateinit var adapter: ArrayAdapter<String>
    lateinit var spinner: Spinner
    lateinit var spinner1: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateArgumentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            val createtitle = binding.editText.text.toString()
            val userName = binding.UserName.text.toString()

            spinner = findViewById(R.id.spinner)
            val language = spinner.getSelectedItem().toString()

            spinner1 = findViewById(R.id.spinner1)
            val handrise = spinner1.getSelectedItem().toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(createtitle,userName,language,handrise)
            database.child(userName).setValue(User).addOnSuccessListener {
                binding.editText.text.clear()
                binding.UserName.text.clear()

                Toast.makeText(this,"Successfully create",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
        val data = arrayListOf<String>("English", "தமிழ", "हिन्द")
        adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter

        val data1 = arrayListOf<String>("Open to Everyone", "Follower Only", "Off")
        adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, data1)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner = findViewById(R.id.spinner1)
        spinner.adapter = adapter

    }
}


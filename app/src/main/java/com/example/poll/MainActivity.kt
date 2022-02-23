package com.example.poll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var startroom: Button
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<RoomUser>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        startroom = findViewById(R.id.start_button)
        startroom.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateArgument_Activity::class.java)
            startActivity(intent)
        }


        userRecyclerView = findViewById(R.id.roomlist)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<RoomUser>()
        getUserData()

    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Users")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(RoomUser::class.java)
                        userArrayList.add((user!!))
                    }
                    userRecyclerView.adapter = MyRoomAdapter(userArrayList)

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}
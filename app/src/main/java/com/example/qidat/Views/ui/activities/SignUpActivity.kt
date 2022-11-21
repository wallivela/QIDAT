package com.example.qidat.Views.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qidat.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase

import com.google.firebase.database.ktx.database

class SignUpActivity: AppCompatActivity(){
    lateinit var home: Button
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var dbReference: DatabaseReference
    lateinit var name:EditText
    lateinit var birthday:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        firebaseAuth= Firebase.auth
        dbReference= Firebase.database.reference.child("User")
        home= findViewById(R.id.register)
        name= findViewById(R.id.signupName)
        val email= findViewById<EditText>(R.id.signupEmail)
        birthday= findViewById(R.id.signupBirthday)
        val password= findViewById<EditText>(R.id.signupPassword)
        home.setOnClickListener {
            createUser(email.text.toString(),password.text.toString())
        }
    }
    private fun createUser(email:String, password:String){
        val na:String= name.text.toString()
        val bi:String= birthday.text.toString()
        firebaseAuth.createUserWithEmailAndPassword(email,password).
        addOnCompleteListener(this){
                Task->if (Task.isSuccessful){
            val user=firebaseAuth.currentUser
            val userdb= dbReference.child(user?.uid.toString())
            userdb.child("name").setValue(na)
            userdb.child("birthday").setValue(bi)

            startActivity(Intent(this,LoginActivity::class.java))
        }
        else{
            Toast.makeText(applicationContext,"No se puede registrar este usuario",Toast.LENGTH_LONG).show()

        }
        }
    }
}
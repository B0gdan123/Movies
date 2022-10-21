package com.example.myproject.view
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myproject.R
import com.example.myproject.data.User
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database.reference

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setIsSmartLockEnabled(false)
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }


    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse //result from display of Firebase auth
        if (result.resultCode == RESULT_OK) {
            Log.d("devlog", "Success Registration")
            // Successfully signed in
            val authUser = FirebaseAuth.getInstance().currentUser
            authUser?.let {
                val email = it.email.toString()
                val uid = it.uid
                val firebaseUser = User(email, uid)
                database.child("users").child(uid).setValue(firebaseUser)
                val intent = Intent(this@MainActivity, MoviesActivity::class.java)
                startActivity(intent)
            }
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()

        } else {

        }
    }
}


package com.example.myproject.model.repository

import com.firebase.ui.auth.data.model.User


interface FirebaseRepository {

    fun updateUserData(firebaseUser: com.example.myproject.data.User, uid:String)
}
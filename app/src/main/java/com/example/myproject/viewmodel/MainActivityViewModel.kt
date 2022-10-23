package com.example.myproject.viewmodel

import com.example.myproject.data.User
import com.example.myproject.model.repository.FirebaseRepository
import com.example.myproject.model.repository.FirebaseRepositoryImpl



class MainActivityViewModel {
    private val mFirebaseRepository: FirebaseRepository = FirebaseRepositoryImpl()
    fun updateUserData(firebaseUser: User, uid:String){
        mFirebaseRepository.updateUserData(firebaseUser,uid)
    }
}
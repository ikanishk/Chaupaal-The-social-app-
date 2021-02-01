package com.example.socialapp.Daos

import com.example.socialapp.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Userdao {
    val db=FirebaseFirestore.getInstance()
    val usersCollection=db.collection("users")

    fun addUser(user:User){
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                usersCollection.document(user.uid!!).set(it)  //this statement is for alloting id to every user (the uid is the id) and we put this in Globalscope
                                                             //because it is a DAO and DAOs extract data from databases and we don't want any such function running on our main thread
            }

        }

    }

    fun getUserById(uid:String):Task<DocumentSnapshot>{
        return usersCollection.document(uid).get()
    }
}
package com.example.socialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socialapp.Daos.Postdao
import kotlinx.android.synthetic.main.activity_create_post.*

class CreatePostActivity : AppCompatActivity() {
    private lateinit var postdao: Postdao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        postdao = Postdao()

        postButton.setOnClickListener {
            val input = postInput.text.toString().trim()
            if(input.isNotEmpty()) {
                postdao.addPost(input)
                finish()
            }
        }

    }
}
package com.example.realmproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realmproject.core.database.model.UserModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  /**
   *  update user model
   */
  fun updateUser(user: UserModel) {
  }
}
package com.example.realmproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realmproject.core.database.UserRepository
import com.example.realmproject.core.database.model.UserModel
import com.example.realmproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var userRepository: UserRepository

  private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    binding.btnGetUser.setOnClickListener {
      userRepository.getUserModel()?.let {
        binding.textView.text = "ID: ${it.id} \nFull name: ${it.fullName} \nEmail: ${it.email}"
      }
    }
    binding.btnSaveUser.setOnClickListener {
      updateUser(
        UserModel("123", binding.txtFullName.text.toString(), binding.txtEmail.text.toString())
      )
    }
  }

  /**
   *  update user model
   */
  private fun updateUser(user: UserModel) {
    GlobalScope.launch {
      userRepository.saveUser(user)
    }
  }
}
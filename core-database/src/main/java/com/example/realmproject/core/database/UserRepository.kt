package com.example.realmproject.core.database

import com.example.realmproject.core.database.model.UserDto
import com.example.realmproject.core.database.model.UserModel
import com.example.realmproject.core.database.model.toModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
  private val config = RealmConfiguration.Builder(schema = setOf(UserDto::class))
    .build()
  private val realm = Realm.open(config)

  fun getUserModel(): UserModel? {
    return realm.query<UserDto>().first().find()?.toModel()
  }

  suspend fun saveUser(userModel: UserModel) {
    realm.write {
      val user = this.query<UserDto>().first().find()
      if (user != null) {
        user.fullName = userModel.fullName
        user.email = userModel.email
      } else {
        this.copyToRealm(UserDto().apply {
          id = userModel.id
          fullName = userModel.fullName
          email = userModel.email
        })
      }
    }
  }
}
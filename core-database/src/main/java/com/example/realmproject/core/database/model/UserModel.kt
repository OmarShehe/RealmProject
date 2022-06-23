package com.example.realmproject.core.database.model

import io.realm.kotlin.types.RealmObject

class UserDto : RealmObject {
  var id: String = ""
  var fullName: String = ""
  var email: String = ""
}

class UserModel(
  var id: String = "",
  var fullName: String = "",
  var email: String = "",
)

fun UserDto.toModel(): UserModel {
  return UserModel(id, fullName, email)
}
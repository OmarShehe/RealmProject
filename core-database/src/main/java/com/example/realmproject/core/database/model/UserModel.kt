package com.example.realmproject.core.database.model

import io.realm.kotlin.types.RealmObject

class UserModel : RealmObject {
  var id: String = ""
  var fullName: String = ""
  var email: String = ""
}
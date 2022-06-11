package com.dicoding.mysimplelogin

import javax.inject.Inject

//Injection Construtor
class UserRepository @Inject constructor(private val sesi: SessionManager) {

    // Hapus
//    companion object {
//        @Volatile
//        private var instance: UserRepository? = null
//
//        fun getInstance(sesi: SessionManager): UserRepository =
//            instance ?: synchronized(this) {
//                instance ?: UserRepository(sesi)
//            }
//    }

    fun loginUser(username: String) {
        sesi.createLoginSession()
        sesi.saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sesi.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun logoutUser() = sesi.logout()
}
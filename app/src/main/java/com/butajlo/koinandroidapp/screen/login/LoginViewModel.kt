package com.butajlo.koinandroidapp.screen.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.domain.loginUser
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import com.butajlo.koinandroidapp.rx.execute

class LoginViewModel(private val repository: PlaceholderRepository) : ViewModel() {

    val isLogin = MutableLiveData<Boolean>()
    val usernameFieldErrorRes = MutableLiveData<Int>()
    val passwordFieldErrorRes = MutableLiveData<Int>()

    fun login(username: String, password: String) {
        loginUser(repository, username).execute(
            onSuccess = { isLogin.value = true },
            onError = {
                isLogin.value = false
                Log.e(javaClass.simpleName, "Error during user login", it)
            }
        )
    }

    fun validateUsername(username: String) {
        if (username.isEmpty()) {
            usernameFieldErrorRes.value = R.string.username_field_empty
        }
    }

    fun validatePassword(password: String) {
        if(password.isEmpty()) {
            passwordFieldErrorRes.value = R.string.password_field_empty
        }
    }
}
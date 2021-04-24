package com.alvin.uts_18090121.activity.login

import com.alvin.uts_18090121.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg: String?)
}
package com.alvin.uts_18090121.activity.register.presenter

import com.alvin.uts_18090121.model.User
import com.alvin.uts_18090121.network.NetworkConfig
import com.alvin.uts_18090121.response.ResultSimple
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {
    fun register(user: User) {
        NetworkConfig.service()
            .registerUser(user.username, user.email, user.password, user.hp)
            .enqueue(object: Callback<ResultSimple> {
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    registerView.onErrorRegister(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    if (response.body()?.status == 200) {
                        registerView.onSuccessRegister()
                    } else {
                        registerView.onErrorRegister(response.body()?.message)
                    }
                }

            })
    }
}
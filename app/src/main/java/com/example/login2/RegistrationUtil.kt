package com.example.login2

object RegistrationUtil {
    var existingUsers = listOf("cosmicF", "cosmicY", "bob", "alice")

    //exists or length
    fun validateUsername(username: String): Boolean{
        if(!existingUsers.contains(username) &&
            username.length >= 3 ){
            return true
        }
        return false
    }

    //8 digit 1 num and cap
    fun validatePassword(password : String, confirmPassword: String): Boolean{
        for (v in password){
            if (v.isDigit() &&
                password != password.lowercase() &&
                password.length >= 8 ){
                    return true
            }
        }
        return false
    }

    //not empty
    fun validateName(name: String): Boolean{
        if(name.isNotEmpty()){
            return true
        }
        return false
    }

    //syntax and length
    fun validateEmail(email: String): Boolean{
        if(email.contains("@") &&
            email.contains(".") &&
            email.length >= 3 ){
            return true
        }
        return false
    }
}
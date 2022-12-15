package com.rupesh.testingjunit.Utils

object RegistationUtils {
private val userList = listOf<String>("Rupesh","Lovely","Ravi","Rani").map { it.toUpperCase() }
    /** Registation is not valid if..
     * user name already exist
     * userName or password is empty
     * password and conformPassword missMatch
     * user name or password less then 2 char
     */
    fun validatedRegistationUser(
        userName: String,
        passWord: String,
        conformPassWord: String): Boolean{
        return !(userList.contains(userName.toUpperCase())
                || userName.isEmpty() || passWord.isEmpty()
                || passWord != conformPassWord
                || userName.length < 2  || passWord.length < 2)
    }

}
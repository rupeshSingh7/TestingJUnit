package com.rupesh.testingjunit.Utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * In Test all method should return void and shoult not have method parameter
 */
class RegistationUtilsTest {

//    @Test
//    fun validatedRegistationUser(userName: String,
//    passWord: String,
//    conformPassWord: String): Boolean{
//       return RegistationUtils.validatedRegistationUser(userName,
//        passWord,conformPassWord)
//    }
    @Test
    fun `is user name not empty True`(){
        val result = RegistationUtils.validatedRegistationUser("User","pass","pass")
        assertThat(result).isTrue()
        assertThat(result).isFalse()
    }
    @Test
    fun `is user name empty false`(){
        val result = RegistationUtils.validatedRegistationUser("","pass","pass")
        assertThat(result).isFalse()
        assertThat(result).isTrue()
    }

    @Test
    fun `is password not empty true`(){
        val result = RegistationUtils.validatedRegistationUser("user","efs","efs")
        assertThat(result).isTrue()
        assertThat(result).isFalse()
    }
    @Test
    fun `is password empty false`(){
        val result = RegistationUtils.validatedRegistationUser("user","","efs")
        assertThat(result).isFalse()
        assertThat(result).isTrue()
    }

    @Test
    fun `is password missMatch false`(){
        val result = RegistationUtils.validatedRegistationUser("user","egsfx","efs")
        assertThat(result).isFalse()
        assertThat(result).isTrue()
    }
    @Test
    fun `is password not missMatch true`(){
        val result = RegistationUtils.validatedRegistationUser("user","pass","pass")
        assertThat(result).isTrue()
        assertThat(result).isFalse()
    }
    @Test
    fun `is password or username less then 2 char true`(){
        val result = RegistationUtils.validatedRegistationUser("ur","s","s")
        assertThat(result).isTrue()
        assertThat(result).isFalse()
    }

    fun fib(n: Int): Long{
        if (n == 0 || n == 1)
            return n.toLong()
        var a = 0L
        var b = 1L
        var c = 1L
        for (i in 2 until n) {
            c = a + b
            a = b //1 1 2
            b = c //1 2 3
        }
        return c
    }
    @Test
    fun `fibonix number at n position`(){
        val result = fib(4)
        assertThat(result).isEqualTo(2)
    }
}
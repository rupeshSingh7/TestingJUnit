package com.rupesh.testingjunit.Utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.rupesh.testingjunit.R
import org.junit.Before
import org.junit.Test

class StringResourceCompairareTest{
    private lateinit var stringResourceCompairare:StringResourceCompairare
   @Before
   fun setUp(){
       stringResourceCompairare = StringResourceCompairare()
   }
    @Test
    fun checkContextStringTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = stringResourceCompairare.equal(context,R.string.app_name,"TestingJUnit")
        assertThat(result).isTrue()
    }
    @Test
    fun checkContextStringFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = stringResourceCompairare.equal(context,R.string.app_name,"Testing")
        assertThat(result).isFalse()
    }
}
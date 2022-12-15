package com.rupesh.testingjunit.Utils

import android.content.Context

class StringResourceCompairare {
    fun equal(context: Context,resId: Int,string: String): Boolean{
        return context.getString(resId) == string
    }
}
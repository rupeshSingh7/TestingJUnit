package com.rupesh.testingjunit.data.local


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_list", primaryKeys = ["id"], ignoredColumns = ["amount"])
data class ShoppingItem(
    @NonNull
    val id: Long = 0,
    var name: String,
    var amount: Int,
    var price: Float
){
    val  abslotePrice = amount * price
}

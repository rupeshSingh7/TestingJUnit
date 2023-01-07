package com.rupesh.testingjunit.data.local


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "shopping_list", primaryKeys = ["id"], ignoredColumns = ["amount"])
@Entity(tableName = "shopping_list")
data class ShoppingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var  totalPrice = amount * price
}

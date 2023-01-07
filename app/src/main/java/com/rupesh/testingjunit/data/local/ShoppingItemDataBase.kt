package com.rupesh.testingjunit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = arrayOf(ShoppingItem::class),
version = 1)
abstract class ShoppingItemDataBase: RoomDatabase(){
    abstract fun shoppingDoa():ShoppingDao

}
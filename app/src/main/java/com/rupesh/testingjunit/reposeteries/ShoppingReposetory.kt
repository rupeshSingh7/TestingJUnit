package com.rupesh.testingjunit.reposeteries

import androidx.lifecycle.LiveData
import com.rupesh.testingjunit.data.local.ShoppingItem
import com.rupesh.testingjunit.data.remote.responses.ImageResponse
import com.rupesh.testingjunit.other.Resource
import retrofit2.Response

interface ShoppingReposetory {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
    suspend fun observeAllShoppingItem():List<ShoppingItem>
    suspend fun observeTotalPrice(): List<Float>
    suspend fun searchForImage(imageQueary: String): Resource<ImageResponse >
}
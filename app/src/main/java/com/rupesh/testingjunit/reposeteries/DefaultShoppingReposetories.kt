package com.rupesh.testingjunit.reposeteries

import androidx.lifecycle.LiveData
import com.rupesh.testingjunit.data.local.ShoppingDao
import com.rupesh.testingjunit.data.local.ShoppingItem
import com.rupesh.testingjunit.data.remote.responses.ImageResponse
import com.rupesh.testingjunit.data.remote.responses.PixelBayAPI
import com.rupesh.testingjunit.other.Resource
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class DefaultShoppingReposetories @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixelBayAPI: PixelBayAPI
): ShoppingReposetory{
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppintItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override suspend fun observeAllShoppingItem(): List<ShoppingItem> {
      return  shoppingDao.observeAllShoppingList()
    }

    override suspend fun observeTotalPrice(): List<Float> {
        return shoppingDao.observeTAbsloteTotalPrice()
    }

    override suspend fun searchForImage(imageQueary: String): Resource<ImageResponse> {
        return try {
            val response = pixelBayAPI.searchForImage(imageQueary)
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknow error accured",null)
            }else {
                Resource.error("An unknow error accured",null)
            }
        }catch (e: Exception){
            Resource.error("Error: ${e.printStackTrace()}",null)
        }
    }
}
package com.rupesh.testingjunit.data.local

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {
    @get:Rule
    val instanceTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dataBase: ShoppingItemDataBase
    private lateinit var dao: ShoppingDao

    /**
     * inMemoryDatabaseBuilder: temp dataBase create in as in ram
     * allowMainThreadQueries(): allow to access dataBase from main threat,
     * in testing explicity ussaly we use single thread, different threat manipulate diff dataBAse so
     */
    @Before
    fun setUp(){
         dataBase = Room.inMemoryDatabaseBuilder(
             ApplicationProvider.getApplicationContext(),
             ShoppingItemDataBase::class.java
         ).allowMainThreadQueries().build()
        dao = dataBase.shoppingDoa()
    }
    @After
    fun tearDown(){
        dataBase.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {
        val shoppingItem = ShoppingItem(name = "Rupesh", amount = 40,
        price = 40f, imageUrl = "")
      val test1 = dao.insertShoppintItem(shoppingItem)
        assertThat(test1).isNotNull()
//       val allShoppingItem = dao.observeAllShoppingList().getOrAwaitValue()
//        Truth.assertThat(allShoppingItem).isEqualTo(shoppingItem)
       val allShoppingItem = dao.observeAllShoppingList()
       assertThat(allShoppingItem).contains(shoppingItem)
    }
    var delete = 0
    @Test
    fun deleteShoppingItem() = runBlockingTest {
        val shoppingItem = ShoppingItem("name", 1, 1f, "url")
        dao.insertShoppintItem(shoppingItem)
        val getall = dao.observeAllShoppingList()
        Log.d("Delete","list $getall")
        delete = dao.deleteShoppingItem(getall[0])
//        delete = dao.deleteShoppingItem(shoppingItem)

        val allShoppingItems = dao.observeAllShoppingList()
        assertThat(allShoppingItems).doesNotContain(shoppingItem)
    }
    @Test
    fun observeTotalPriceSum() = runBlockingTest {
        val shoppingItem1 = ShoppingItem("name", 2, 10f, "url")
        val shoppingItem2 = ShoppingItem("name", 4, 5.5f, "url")
        val shoppingItem3 = ShoppingItem("name", 0, 100f, "url")
        dao.insertShoppintItem(shoppingItem1)
        dao.insertShoppintItem(shoppingItem2)
        dao.insertShoppintItem(shoppingItem3)

        val totalPriceSum = dao.observeTAbsloteTotalPrice()

        assertThat(totalPriceSum).isEqualTo(2 * 10f + 4 * 5.5f)
    }
}
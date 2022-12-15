package com.rupesh.testingjunit.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *  You can define each DAO as either an interface or an abstract class.
 *  you must always annotate your DAOs with @Dao.
 *  There are two types of DAO methods that define database interactions:
1)Convenience methods that let you insert, update, and delete rows in your database without writing any SQL code.
2)Query methods that let you write your own SQL query to interact with the database.
 */
@Dao
interface ShoppingDao {
    //1)Convenience methods
    /**
     * The @Insert annotation allows you to define methods
     * that insert their parameters into the appropriate table in the database.
     * @Insert(onConflict = OnConflictStrategy.REPLACE): UNIQUE, NOT NULL, CHECK, and PRIMARY KEY constraints.
     *  fun insert(item1: ShoppingItem, item2: ShoppingItem)
     *  fun insert2(item: ShoppingItem, others: List<ShoppingItem>)
     *  RETURN
     *  If the @Insert method have single parameter then return a Int value, which is the new rowId
     */
    @Insert
    suspend fun insertShoppintIter(vararg shoppingItem: ShoppingItem)

    /**
     * Similarly to @Insert methods
     * Room uses the primary key to match passed entity instances to rows in the database.
     * If there is no row with the same primary key, Room makes no changes
     *  return an int value indicating the number of rows that were deleted successfully.
     */
    @Delete
    suspend fun deleteShoppingItem(vararg shoppingItem: ShoppingItem)

    /** Similarly to @Delete methods
     * return an int value indicating the number of rows that were updated successfully.
     */
    @Update
    suspend fun updateShoppintItem(vararg shoppingItem: ShoppingItem)

   //2)Query methods
    /**
     *
     */
    @Query("select * from shopping_list")
    suspend fun  observeAllShoppingList(): LiveData<ShoppingItem>

    @Query("select SUM(amount * price) from shopping_list")
    suspend fun  observeTAbsloteTotalPrice(): LiveData<Float>

    @Query("SELECT * FROM shopping_list WHERE price BETWEEN :min AND :max")
    fun loadAllUsersBetweenAges(min: Int, max: Int): LiveData<ShoppingItem>

    @Query("SELECT * FROM shopping_list WHERE name LIKE :search " +
            "OR price LIKE :search")
    fun findUserWithName(search: String): LiveData<ShoppingItem>
}
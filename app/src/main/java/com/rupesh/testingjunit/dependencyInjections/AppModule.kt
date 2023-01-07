package com.rupesh.testingjunit.dependencyInjections

import android.content.Context
import androidx.room.Room
import com.rupesh.testingjunit.data.local.ShoppingItemDataBase
import com.rupesh.testingjunit.data.remote.responses.PixelBayAPI
import com.rupesh.testingjunit.other.Constant.BASE_URL
import com.rupesh.testingjunit.other.Constant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,ShoppingItemDataBase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideShoppingDao(dataBase: ShoppingItemDataBase) = dataBase.shoppingDoa()

    @Singleton
    @Provides
    fun providePixabayApis(): PixelBayAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixelBayAPI::class.java)
    }


}
package com.example.numbers.hilt

import android.content.Context
import androidx.room.Room
import com.example.numbers.api.NumbersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.numbers.room.DBase
import com.example.numbers.room.NumberDao
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

   @Provides
   @Singleton
   fun provideInstance(@ApplicationContext context: Context) : DBase {
       return Room.databaseBuilder(context, DBase::class.java, "database")
           .build()
   }

    @Provides
    fun provideUserDao(dbase : DBase) : NumberDao {
        return dbase.getDao()
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://numbersapi.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit : Retrofit) : NumbersApi {

        return retrofit.create(NumbersApi::class.java)
    }
}
package com.andreisingeleytsev.soccernotebet.di

import android.app.Application

import androidx.room.Room
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.PlayersRepository
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.TeamRepository
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.PlayersRepositoryImpl
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.TeamRepositoryImpl
import com.andreisingeleytsev.soccernotebet.data.room.MainDataBase
import com.andreisingeleytsev.soccernotebet.data.room.repository.NoteItemRepository
import com.andreisingeleytsev.soccernotebet.data.room.repository.implementations.NoteItemRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDatabase(app: Application): MainDataBase {
        return Room.databaseBuilder(
            app,
            MainDataBase::class.java,
            "sport_quiz_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteItemRepository(db: MainDataBase): NoteItemRepository {
        return NoteItemRepositoryImpl(db.noteItemDao)
    }

    @Provides
    @Singleton
    fun provideMainRESTAPI(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder().baseUrl("https://v3.football.api-sports.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTeamAPI(retrofit: Retrofit): TeamRepository {
        return TeamRepositoryImpl(retrofit)
    }
    @Provides
    @Singleton
    fun providePlayersAPI(retrofit: Retrofit): PlayersRepository {
        return PlayersRepositoryImpl(retrofit)
    }

}
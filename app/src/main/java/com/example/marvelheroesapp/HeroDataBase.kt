package com.example.marvelheroesapp

import android.content.Context
import androidx.room.*

@Dao
interface HeroDataBase {
    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<EntityHero>

    @Query("SELECT * FROM heroes WHERE id = :heroId LIMIT 1")
    suspend fun getHeroById(heroId: Int): EntityHero?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroes: List<EntityHero>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(hero: EntityHero)

    @Query("DELETE FROM heroes")
    suspend fun deleteAllHeroes()
}

@Database(entities = [EntityHero::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun heroBD(): HeroDataBase

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

@Entity(tableName = "heroes")
data class EntityHero(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String
)

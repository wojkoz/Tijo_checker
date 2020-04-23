package com.example.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.dao.IndexDao
import com.example.core.dao.IndexDetailsDao
import com.example.core.dao.LabDao
import com.example.core.entity.room.IndexDetailsEntity
import com.example.core.entity.room.IndexEntity
import com.example.core.entity.room.LabEntity

@Database(entities = [IndexEntity::class, IndexDetailsEntity::class, LabEntity::class],
    version = 3)
abstract class IndexDatabase : RoomDatabase() {
    abstract fun indexDao(): IndexDao
    abstract fun indexDetailsDao(): IndexDetailsDao
    abstract fun labDao(): LabDao

    companion object {

        @Volatile
        private var INSTANCE: IndexDatabase? = null

        fun getDatabase(context: Context): IndexDatabase? {
            if (INSTANCE == null) {
                synchronized(IndexDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            IndexDatabase::class.java, "spacex_database"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
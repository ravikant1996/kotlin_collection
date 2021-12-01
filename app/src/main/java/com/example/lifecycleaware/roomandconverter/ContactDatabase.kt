package com.example.lifecycleaware.roomandconverter

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDAO

    companion object {
        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("Alter table contact add column isActive Integer not null default(1)")
            }
        }

        // kuch bi value change hoti h to sabhi thread ko pta chl jata h

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                // isse sirf ak hi instance create hoga
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java, "contactDB"
                    ).addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}
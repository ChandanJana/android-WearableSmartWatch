package com.tiwatch.shared.di;

import android.app.Application;

import androidx.room.Room;

import com.tiwatch.shared.LoginModelDao;
import com.tiwatch.shared.TiWatchDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */

@Module
@InstallIn(SingletonComponent.class)
public abstract class DatabaseModule {

    @Provides
    @Singleton
    public static TiWatchDatabase provideDatabase(final Application application) {
        return Room.databaseBuilder(application.getApplicationContext(), TiWatchDatabase.class, "tiwatch_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static LoginModelDao provideNoteDao(TiWatchDatabase database) {
        return database.loginModelDao();
    }
}

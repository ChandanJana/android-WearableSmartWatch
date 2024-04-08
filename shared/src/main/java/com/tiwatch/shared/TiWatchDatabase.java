package com.tiwatch.shared;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */


@Database(entities = {LoginModel.class}, autoMigrations = {
        /*@AutoMigration(from = 1, to = 1, spec = TiWatchDatabase.TiWatchAutoMigration.class)*/
},
        version = 1, exportSchema = true)
public abstract class TiWatchDatabase extends RoomDatabase {

    public abstract LoginModelDao loginModelDao();

    static class TiWatchAutoMigration implements AutoMigrationSpec {
        @Override
        public void onPostMigrate(SupportSQLiteDatabase database) {
            // Invoked once auto migration is done

        }
    }


}

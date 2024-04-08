package com.tiwatch.shared;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */

@Dao
public interface LoginModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertLoginModel(LoginModel model);

    @Query("SELECT * FROM login_table ORDER BY ID")
    List<LoginModel> loadAllLoginModel();

    @Update
    void updateLoginModel(LoginModel model);

    @Delete
    void deleteLoginModel(LoginModel model);

    @Query("DELETE FROM login_table")
    int deleteAll();
}

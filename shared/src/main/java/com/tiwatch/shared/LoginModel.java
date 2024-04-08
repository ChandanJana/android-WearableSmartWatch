package com.tiwatch.shared;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
@Entity(tableName = "login_table")
public class LoginModel {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "userId")
    @SerializedName("userId")
    String userId;
    @ColumnInfo(name = "password")
    @SerializedName("password")
    String password;
    @ColumnInfo(name = "isLogin")
    boolean isLogin = false;
}

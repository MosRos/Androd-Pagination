/*
 * *
 *  * Created by Moslem Rostami on 6/16/20 1:48 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 6/16/20 1:48 PM
 *
 */

package com.morostami.androidpagination.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.morostami.androidpagination.domain.model.CoinsRemoteKeys

@Dao
interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRemoteKeys(remoteKey: List<CoinsRemoteKeys>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRemoteKey(remoteKey: CoinsRemoteKeys)

    @Query("SELECT * FROM CoinsRemoteKeys WHERE coin_Id = :coinId")
    suspend fun remoteKeysCoinId(coinId: String): CoinsRemoteKeys?

    @Query("DELETE FROM CoinsRemoteKeys")
    suspend fun clearCoinsRemoteKeys()
}
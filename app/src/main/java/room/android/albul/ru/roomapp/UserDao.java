package room.android.albul.ru.roomapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM table_users")
    Single<List<User>> getAll();

    @Query("SELECT * FROM table_users WHERE id = :id")
    Single<List<User>> getAllById(int id);

    @Insert
    long insert(User user);

    @Insert
    List<Long> insertList(List<User> users);

    @Delete
    int delete(User user);

    @Update
    int update(User user);

}

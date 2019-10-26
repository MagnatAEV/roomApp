package room.android.albul.ru.roomapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "table_users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String surname;

    public String age;

    @Override
    public String toString(){
        return "User( name: " + name +
                ", surname: " + surname +
                ", age: " + age +
                " )";
    }
}

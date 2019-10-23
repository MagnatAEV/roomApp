package room.android.albul.ru.roomapp;


import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    private static AppDatabase appDatabase;

    @Override
    public void onCreate(){
        super.onCreate();

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_db").build();
    }

    public static AppDatabase getAppDatabase(){
        return appDatabase;
    }

}

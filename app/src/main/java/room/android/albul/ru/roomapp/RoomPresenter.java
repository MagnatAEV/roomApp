package room.android.albul.ru.roomapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class RoomPresenter {

    private static String TAG = "Pereseneter";
    private UserDao userDao;

    public RoomPresenter(){
        userDao = App.getAppDatabase().userDao();
    }

    public void  putData(User user){
        Disposable disposable= insertUser(user).observeOn(AndroidSchedulers.mainThread())
                   .subscribe(id->{
                       Log.d(TAG, "putData: " + user.name);
                   }, throwable -> {
                       Log.d(TAG, "putData: " + throwable);
                   });
    }

    private Single<Long> insertUser(User user){

        return Single.create((SingleOnSubscribe<Long>) emitter -> {
            long id = userDao.insert(user);
            emitter.onSuccess(id);
        }).subscribeOn(Schedulers.io());
    }

    private Single<Long> insertListUsers(ArrayList<User> users){
        return Single.create((SingleOnSubscribe<Long>) emitter->{
            List<Long> longList = userDao.insertList(users);
            emitter.onSuccess(longList.get(0));
        }).subscribeOn(Schedulers.io());
    }

    public void getData(){
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(users -> {
                        Log.d(TAG, "getData: " + users);
                    }, throwable -> {
                        Log.d(TAG, "getData: " + throwable);
                    });
    }

    public void deleteData(User user){
        Disposable disposable = deleteUser(user).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id->{
                    Log.d(TAG, "deleteData: " + id);
                }, throwable -> {
                    Log.d(TAG, "deleteData: " + throwable);
                });

    }

    private Single<Integer> deleteUser(User user){
        return Single.create((SingleOnSubscribe<Integer>) emitter ->{
          int pos = userDao.delete(user);
          emitter.onSuccess(pos);
        }).subscribeOn(Schedulers.io());
    }

}

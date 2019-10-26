package room.android.albul.ru.roomapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindFloat;
import butterknife.BindView;
import butterknife.OnClick;

public class RoomActivity extends AppCompatActivity {

    @BindView(R.id.user_name)
    EditText et_name;
    @BindView(R.id.user_surname)
    EditText et_surname;
    @BindView(R.id.user_age)
    EditText et_age;


    private RoomPresenter roomPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        roomPresenter = new RoomPresenter();
    }

    @OnClick(R.id.btn_insert)
    public void putData(View view){
        User user = new User();
        user.name = et_name.getText().toString();
        user.surname = et_surname.getText().toString();
        user.age = et_age.getText().toString();
        roomPresenter.putData(user);
    }


    public void getData(View view){
        roomPresenter.getData();
    }

    @OnClick(R.id.btn_delete)
    public void deleteData(View view){
        User user = new User();
        user.name = et_name.getText().toString();
        user.surname = et_surname.getText().toString();
        user.age = et_age.getText().toString();
        roomPresenter.deleteData(user);
    }

}

package com.littl3bear.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String user;
    private String pass;
    private String name;
    private String sname;
    private String email;
    private String call;
    private String sex;
    private int skill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText u = (EditText) findViewById(R.id.etUser);
        final EditText p = (EditText) findViewById(R.id.etPass);
        final EditText n = (EditText) findViewById(R.id.etName);
        final EditText sn = (EditText) findViewById(R.id.etSname);
        final EditText e = (EditText) findViewById(R.id.etEmail);
        final EditText c = (EditText) findViewById(R.id.etCall);
        final TextView s = (TextView) findViewById(R.id.tvShow);

        findViewById(R.id.btSubmit).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                user = u.getText().toString();
                pass = p.getText().toString();
                name = n.getText().toString();
                sname = sn.getText().toString();
                email = e.getText().toString();
                call = c.getText().toString();

                if (TextUtils.isEmpty(user)) {
                    u.setError("Please enter your username");
                    u.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    p.setError("Please enter your password");
                    p.requestFocus();
                    return;
                }

                else {
                    s.setText(user+"\n"+pass+"\n"+name+' '+sname+"\n"+email+"\n"+call+"\n"+sex+"\n");
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rbM:
                if (checked)
                    sex = "Male";
                break;
            case R.id.rbF:
                if (checked)
                    sex = "Female";
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.cbJ:
                if (checked)
                    skill = 1;
                break;
            case R.id.cbC:
                if (checked)
                    skill = 2;
                break;
            case R.id.cbP:
                if (checked)
                    skill = 3;
                break;
            case R.id.cbS:
                if (checked)
                    skill = 4;
                break;
        }
    }

    public void onClickReset(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }
}

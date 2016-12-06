package com.giou.editortest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.user_name)
    EditText mUserName;
    @InjectView(R.id.password)
    EditText mPassword;
    @InjectView(R.id.iv_show)
    ImageView mIvShow;
    @InjectView(R.id.login)
    Button mLogin;
    private boolean isHidden=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.user_name, R.id.password, R.id.iv_show, R.id.login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_name:
                break;
            case R.id.password:
                break;
            case R.id.iv_show:
                showEditor();
                break;
            case R.id.login:
                break;
        }
    }

    private void showEditor() {
        if (isHidden) {
            //设置EditText文本为可见的
            mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            //设置EditText文本为隐藏的
            mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        isHidden = !isHidden;
        mPassword.postInvalidate();
        //切换后将EditText光标置于末尾
        CharSequence charSequence = mPassword.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }
}

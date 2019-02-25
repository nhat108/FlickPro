package com.example.nux.flickpro.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nux.flickpro.MainActivity;
import com.example.nux.flickpro.R;

public class LogInFragment extends Fragment {
    EditText mUsername;
    EditText mPasswords;
    Button mLoginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        mUsername = view.findViewById(R.id.username_editText);
        mPasswords = view.findViewById(R.id.passwords_EditText);
        mLoginButton = view.findViewById(R.id.bt_log_in);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true) {
                    Intent intent=new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    private boolean checkLogin() {
        String username = mUsername.getText().toString();
        String passwords = mPasswords.getText().toString();
        if (username.isEmpty() || passwords.isEmpty()) {
            return false;

        }
        return true;
    }
}

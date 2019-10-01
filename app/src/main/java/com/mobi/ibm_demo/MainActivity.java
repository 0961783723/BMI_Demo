package com.mobi.ibm_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtKG, edtchieucao;
    RadioGroup radioGroup;
    RadioButton rbtn_gay, rbtn_less;
    Button btnBMI;

    public static final String BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtchieucao = findViewById(R.id.editchieucao);
        edtKG = findViewById(R.id.editKG);

        radioGroup = findViewById(R.id.radioGroup);

        rbtn_gay = findViewById(R.id.rbtn_gay);
        rbtn_less = findViewById(R.id.rbtn_less);

        btnBMI = findViewById(R.id.btnBMI);

        checkRadion();

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtn_gay.isChecked()) {
                    byBundleMan();
                }

                if (rbtn_less.isChecked()){
                    byBundleWoman();
                }
            }
        });
    }

    public void byBundleMan() {
        String Name, chieuCao, canNang;
        Name = edtName.getText().toString();
        chieuCao = edtchieucao.getText().toString();
        canNang = edtKG.getText().toString();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ten", Name);
        bundle.putString("chieuCao", chieuCao);
        bundle.putString("canNang", canNang);
        intent.putExtra(BUNDLE, bundle);
        startActivity(intent);
    }


    public void byBundleWoman() {
        String NameK, chieuCaoK, canNangK;
        NameK = edtName.getText().toString();
        chieuCaoK = edtchieucao.getText().toString();
        canNangK = edtKG.getText().toString();
        Intent intent = new Intent(MainActivity.this, MainGirl.class);
        Bundle bundle = new Bundle();
        bundle.putString("ten", NameK);
        bundle.putString("chieuCao", chieuCaoK);
        bundle.putString("canNang", canNangK);
        intent.putExtra(BUNDLE, bundle);
        startActivity(intent);
    }


    public void checkRadion() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // trả id của radioButton đang đc chọn
                switch (checkedId) {
                    case R.id.rbtn_gay:
                        Toast.makeText(MainActivity.this, "Bạn Là Nam", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtn_less:
                        Toast.makeText(MainActivity.this, "Bạn Là Nữ", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


}

package com.mobi.ibm_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    TextView tvName, tvKg, tvCao, tvBMI, tvChandoan, tvKhuyen;
    ImageView imgFat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvKg = findViewById(R.id.tvNang);
        tvCao = findViewById(R.id.tvCao);
        tvBMI = findViewById(R.id.tvBMI);
        tvChandoan = findViewById(R.id.tvChanDoan);
        tvKhuyen = findViewById(R.id.tvKhuyen);

        tvName = findViewById(R.id.tvName);
        imgFat = findViewById(R.id.imgFat);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
        tvName.setText(bundle.getString("ten"));
        tvCao.setText(bundle.getString("chieuCao"));
        tvKg.setText(bundle.getString("canNang"));

        String heightStr = tvCao.getText().toString();
        String weightStr = tvKg.getText().toString();
        {
            if (heightStr != null && !"".equals(heightStr)
                    && weightStr != null && !"".equals(weightStr)) {
                double heightValue = Double.parseDouble(heightStr) / 100;
                double weightValue = Double.parseDouble(weightStr);

                double BMI = weightValue / (heightValue * heightValue);


                String chandoan = "";
                String khuyen = "";
                if (BMI < 18) {
                    imgFat.setImageResource(R.drawable.thin);
                    chandoan = "Bạn gầy";
                    khuyen = "Bạn cần ăn uống đầy đủ, chăm tập thể dục thể thao và giữ một lối sống lành mạnh";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                    khuyen = "Hãy giữ lối sống lành mạnh, chăm tập thể thao để duy trì sức khỏe và vóc dáng";
                } else if (BMI <= 29.9) {
                    imgFat.setImageResource(R.drawable.man_do1);
                    chandoan = "Bạn béo phì độ 1";
                    khuyen = "Bạn cần chăm chỉ tập thể thao và thay đổi thói quen ăn uống của mình";
                } else if (BMI <= 34.9) {
                    imgFat.setImageResource(R.drawable.man_do2);
                    chandoan = "Bạn béo phì độ 2";
                    khuyen = "Thói quen ăn uống của bạn không tốt, cần thay đổi nhiều và chăm chỉ tập thể thao";
                } else {
                    imgFat.setImageResource(R.drawable.man_do3);
                    chandoan = "Bạn béo phì độ 3";
                    khuyen = "Bạn cần ăn kiêng, cần thay đổi việc ăn uống và tập thể thao đều đặn, tránh các nguy cơ về bệnh gây ảnh hưởng tới cơ thể";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                tvBMI.setText(dcf.format(BMI));
                tvChandoan.setText(chandoan);
                tvKhuyen.setText(khuyen);
            }
        }
    }
}

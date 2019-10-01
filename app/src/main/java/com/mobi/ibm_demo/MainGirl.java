package com.mobi.ibm_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainGirl extends AppCompatActivity {

    TextView tvName2, tvKg2, tvCao2, tvBMI2, tvChandoan2, tvKhuyen2;
    ImageView imgFat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_girl);
        tvKg2 = findViewById(R.id.tvNang2);
        tvCao2 = findViewById(R.id.tvCao2);
        tvBMI2 = findViewById(R.id.tvBMI2);
        tvChandoan2 = findViewById(R.id.tvChanDoan2);
        tvKhuyen2 = findViewById(R.id.tvKhuyen2);

        tvName2 = findViewById(R.id.tvName2);
        imgFat2 = findViewById(R.id.imgFat2);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
        tvName2.setText(bundle.getString("ten"));
        tvCao2.setText(bundle.getString("chieuCao"));
        tvKg2.setText(bundle.getString("canNang"));

        String heightStr = tvCao2.getText().toString();
        String weightStr = tvKg2.getText().toString();
        {
            if (heightStr != null && !"".equals(heightStr)
                    && weightStr != null && !"".equals(weightStr)) {
                double heightValue = Double.parseDouble(heightStr) / 100;
                double weightValue = Double.parseDouble(weightStr);

                double BMI = weightValue / (heightValue * heightValue);


                String chandoan = "";
                String khuyen = "";
                if (BMI < 18) {
                    imgFat2.setImageResource(R.drawable.girl_gay);
                    chandoan = "Bạn gầy";
                    khuyen = "Bạn cần ăn uống đầy đủ, chăm tập thể dục thể thao và giữ một lối sống lành mạnh";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                    khuyen = "Hãy giữ lối sống lành mạnh, chăm tập thể thao để duy trì sức khỏe và vóc dáng";
                } else if (BMI <= 29.9) {
                    imgFat2.setImageResource(R.drawable.girl_do1);
                    chandoan = "Bạn béo phì độ 1";
                    khuyen = "Bạn cần chăm chỉ tập thể thao và thay đổi thói quen ăn uống của mình";
                } else if (BMI <= 34.9) {
                    imgFat2.setImageResource(R.drawable.girl_do2);
                    chandoan = "Bạn béo phì độ 2";
                    khuyen = "Thói quen ăn uống của bạn không tốt, cần thay đổi nhiều và chăm chỉ tập thể thao";
                } else {
                    imgFat2.setImageResource(R.drawable.girl_do3);
                    chandoan = "Bạn béo phì độ 3";
                    khuyen = "Bạn cần ăn kiêng, cần thay đổi việc ăn uống và tập thể thao đều đặn, tránh các nguy cơ về bệnh gây ảnh hưởng tới cơ thể";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                tvBMI2.setText(dcf.format(BMI));
                tvChandoan2.setText(chandoan);
                tvKhuyen2.setText(khuyen);
            }
        }
    }
}

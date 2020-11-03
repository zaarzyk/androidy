package com.example.pawelzarzyckigeneratorhasel;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
//zmienne od wyswtielaczy i paska
    TextView tv1;
    EditText ed1;
    SeekBar sb;



//podpinanie wyswietlaczy i paska
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.wyswietlaczgorny);
        tv1 = findViewById(R.id.wyswietlaczdolny);
        sb = (SeekBar)findViewById(R.id.suwak);
//nasłuchwiacz paska
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//reaguje na puszczenie paska
           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {


           }
//reaguje na dotkniecie paska
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


           }
//zapis i wyświetlanie pozycji/postepu paska
            @Override
            public void onProgressChanged(SeekBar seekBar, int postep,
                                          boolean fromUser) {
//tutaj dokladnie jest wyswietlanie
                tv1.setText(String.valueOf("Długość hasła:  " + postep));

            }
        });
    }





//generator- tutaj jest kod odpowiedzialny za generowanie hasla
    public void generator(View view) {


        int min = 33; // minimum z systemu kodowania znaków ASCII
        int max = 126; //maksimum ASCII
        int dlugosc = sb.getProgress(); //zmienna dlugosc czyli dane z paska postepu




        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < dlugosc; i++){ //pętla for generująca haslo o dlugosci wybranej w pasku
            builder.append((char) ThreadLocalRandom.current().nextInt(min , max ));//losowanie znaku z systemu znakow ASCII

        }


        ed1.setText(builder);//wywietlanie hasla


    }


}




package com.example.kopapirollo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageButton paperButton;
    private ImageButton scissersButton;
    private ImageButton rockButton;
    private ImageView botvalaszt;
    private ImageView gamervalaszt;
    private TextView dontetlen;
    private  int szam=0;
    private int eletember= 3;
    private int eletbot=3;
    private int kitalaltSzam=0;
    private Random random;
    private ImageView hear1;
    private ImageView hear2;
    private ImageView hear3;
    private ImageView hear1bot;
    private ImageView hear2bot;
    private ImageView hear3bot;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
init();
paperButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        gamervalaszt.setImageResource(R.drawable.paper);
        random= new Random();
        kitalaltSzam= random.nextInt(3);
        if(kitalaltSzam==0){
            botvalaszt.setImageResource(R.drawable.rock);
            eletModositasBot();

        } else if (kitalaltSzam==1) {
            botvalaszt.setImageResource(R.drawable.paper);
            szam++;
            dontetlen.setText("Döntetlenek száma: "+ szam);


        } else if (kitalaltSzam==2) {
            botvalaszt.setImageResource(R.drawable.scissors);
            eletModositasEmber();
        }
    }
});
scissersButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        gamervalaszt.setImageResource(R.drawable.scissors);
        random= new Random();
        kitalaltSzam= random.nextInt(3);
        if(kitalaltSzam==0){
            botvalaszt.setImageResource(R.drawable.rock);
            eletModositasEmber();

        } else if (kitalaltSzam==1) {
            botvalaszt.setImageResource(R.drawable.paper);
            eletModositasBot();

        } else if (kitalaltSzam==2) {
            botvalaszt.setImageResource(R.drawable.scissors);
            szam++;
            dontetlen.setText("Döntetlenek száma: "+ szam);

        }
    }
});
rockButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        gamervalaszt.setImageResource(R.drawable.rock);
        random= new Random();
        kitalaltSzam= random.nextInt(3);
        if(kitalaltSzam==0){
            botvalaszt.setImageResource(R.drawable.rock);
            szam++;
            dontetlen.setText("Döntetlenek száma: "+ szam);

        } else if (kitalaltSzam==1) {
            botvalaszt.setImageResource(R.drawable.paper);
            eletModositasEmber();

        } else if (kitalaltSzam==2) {
            botvalaszt.setImageResource(R.drawable.scissors);
            eletModositasBot();
        }
    }
});
    }
    public void eletModositasEmber(){
        eletember--;
        if(eletember==2){
            hear3.setImageResource(R.drawable.heart1);
        }
        if(eletember==1){
            hear2.setImageResource(R.drawable.heart1);
        }
        if(eletember==0){
            hear1.setImageResource(R.drawable.heart1);
            Toast.makeText(this, "Vesztettél!", Toast.LENGTH_SHORT).show();
            //ujJatek();
            alertDialog.setTitle("Vesztettél!");
            alertDialog.create();
            alertDialog.show();
        }
    }
    public void eletModositasBot(){
        eletbot--;
        if(eletbot==2){
            hear3bot.setImageResource(R.drawable.heart1);
        }
        if(eletbot==1){
            hear2bot.setImageResource(R.drawable.heart1);
        }
        if(eletbot==0){
            hear1bot.setImageResource(R.drawable.heart1);
            Toast.makeText(this, "Nyertél!", Toast.LENGTH_SHORT).show();
            //ujJatek();
            alertDialog.setTitle("Nyertél!");
            alertDialog.create();
            alertDialog.show();
        }
    }
    public void ujJatek(){
        eletbot=3;
        eletember=3;
        szam=0;
        dontetlen.setText("Döntetlenek száma: "+ szam);
        hear3.setImageResource(R.drawable.heart2);
        hear2.setImageResource(R.drawable.heart2);
        hear1.setImageResource(R.drawable.heart2);
        hear3bot.setImageResource(R.drawable.heart2);
        hear2bot.setImageResource(R.drawable.heart2);
        hear1bot.setImageResource(R.drawable.heart2);

    }
    public void init(){
        paperButton= findViewById(R.id.paperButton);
        scissersButton= findViewById(R.id.scissersButton);
        rockButton = findViewById(R.id.rockButton);
        botvalaszt = findViewById(R.id.botvalszt);
        gamervalaszt = findViewById(R.id.gamervalasz);
        hear1 = findViewById(R.id.heart1);
        hear3 = findViewById(R.id.heart3);
        hear2 = findViewById(R.id.heart2);

        hear1bot = findViewById(R.id.heart1bot);
        hear2bot = findViewById(R.id.heart2bot);
        hear3bot = findViewById(R.id.heart3bot);
        dontetlen= findViewById(R.id.dontetlen);



        random= new Random();
        alertDialog= new AlertDialog.Builder(this).
                setTitle("Játék vége!").
                setMessage("Szeretnél-e új játékot?").
                setCancelable(false).
                setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                        alertDialog.show();
                    }
                }).
                setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).create();
    }
}
package br.ici.treinamento.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarGirando;
    private ProgressBar progressBarLinha;
    private Integer progresso =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarGirando = findViewById(R.id.pbGirando);
        progressBarLinha = findViewById(R.id.pbLinha);

        progressBarGirando.setVisibility(View.GONE);


    }

    public void carregandoProgressBar(View view){

        progressBarGirando.setVisibility(View.VISIBLE);

       /* this.progresso = this.progresso+10;
        progressBarLinha.setProgress(this.progresso);*/



       new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i =0; i<=100; i++){
                    final Integer progresso =i;
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           progressBarLinha.setProgress(progresso);
                           if (progresso ==100){
                               progressBarGirando.setVisibility(View.GONE);
                           }
                       }
                   });

                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }).start();
    }
}

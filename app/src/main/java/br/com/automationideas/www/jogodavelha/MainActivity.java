package br.com.automationideas.www.jogodavelha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View view;
    private final String QUADRADO = "quadrado";
    private final String BOLA = "O";
    private final String XIS = "X";
    private String lastPlay = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main, null);
       setView(getLayoutInflater().inflate(R.layout.activity_main, null));
       setContentView(getView());

    }

    public void clickQuadrado(View v){


        //constante da tag de cada botão
        //ultilizamos essa constante para reculperar o botão atravez do metodo get quadrado
        if(lastPlay.equals(XIS)) {
            ((Button)v).setText(BOLA);
            setLastPlay(BOLA);
        }else {
            ((Button)v).setText(XIS);
            setLastPlay(XIS);
        }

        Toast.makeText(getView().getContext(),v.getTag().toString(), Toast.LENGTH_SHORT).show();
    }

    public Button getQuadrado (int tagNum){


        return (Button)getView().findViewWithTag(QUADRADO+tagNum);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }


    public String getLastPlay() {
        return lastPlay;
    }

    public void setLastPlay(String lastPlay) {
        this.lastPlay = lastPlay;
    }
}

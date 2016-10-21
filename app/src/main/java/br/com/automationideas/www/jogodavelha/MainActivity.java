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

    int [][]estadoFinal = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9},

        {1,4,7},
        {2,5,8},
        {3,6,9},

        {1,5,9},
        {3,5,7},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main, null);
       setView(getLayoutInflater().inflate(R.layout.activity_main, null));
       setContentView(getView());
    }

    public void clickQuadrado(View v) {
        //constante da tag de cada botão
        //ultilizamos essa constante para reculperar o botão atravez do metodo get quadrado

        if (((Button) v).getText().equals(".")) {

            if (getLastPlay().equals(XIS)) {
                ((Button) v).setText(BOLA);
                setLastPlay(BOLA);
            } else {
                ((Button) v).setText(XIS);
                setLastPlay(XIS);
            }

           // Toast.makeText(getView().getContext(), v.getTag().toString(), Toast.LENGTH_SHORT).show();
        }else{Toast.makeText(getView().getContext(),"Opa! escolha outro quadrado", Toast.LENGTH_SHORT).show();}

        isFim();
    }

    public void setColorQuadrados (int btn, int colorX){

        getQuadrado(btn).setTextColor(getResources().getColor(colorX));

    }


    public void isFim() {

        for (int x = 0; x <= 7; ++x) {
            String s1 = getQuadrado(estadoFinal[x][0]).getText().toString();
            String s2 = getQuadrado(estadoFinal[x][1]).getText().toString();
            String s3 = getQuadrado(estadoFinal[x][2]).getText().toString();


            if ((!s1.equals(".")) && (!s2.equals(".")) && (!s3.equals("."))) {

                if (s1.equals(s2) && (s2.equals(s3))) {
                    // if(s1 == s2 == s3){
                    //   setColorQuadrados(estadoFinal[x][0], R.color.vermelho);
                    //   setColorQuadrados(estadoFinal[x][1], R.color.vermelho);
                    //   setColorQuadrados(estadoFinal[x][2], R.color.vermelho);
                    setColorQuadrados(estadoFinal[x][0], R.color.vermelho);
                    setColorQuadrados(estadoFinal[x][1], R.color.vermelho);
                    setColorQuadrados(estadoFinal[x][2], R.color.vermelho);
                    Toast.makeText(getView().getContext(), "Fim de jogo", Toast.LENGTH_SHORT).show();
                }
            }
        }
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

    public void newGame (View v){

        setEnableQuadrado(true);

        for(int i=1; i<=9; ++i){
            if(getQuadrado(i)!=null){
               getQuadrado(i).setText(".");
           }
       }
  }

    public void setEnableQuadrado(boolean b){

        for(int i=1;i<=9;++i){
           if(getQuadrado(i)!=null){
               getQuadrado(i).setEnabled(b);
           }
     }
  }
}








package br.com.automationideas.www.jogodavelha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View view;
    private final String QUADRADO = "quadrado";
    //impressa no texto do botão
    private final String BOLA = "O";
    private final String XIS = "X";
    private String lastPlay = "X";
    //guarda o ultimo valor jogado

    int [][]estadoFinal = new int[][]{//matriz que define as condições

        {1,2,3},
        {4,5,6},
        {7,8,9},
//verificar as linhas
        {1,4,7},
        {2,5,8},
        {3,6,9},
//verifica colunas
        {1,5,9},
        {3,5,7},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflando o xlm e guardando a instancia de view
       // setContentView(R.layout.activity_main, null);
       setView(getLayoutInflater().inflate(R.layout.activity_main, null));
        //passando a instancia da view para a activity
       setContentView(getView());
    }

    public void clickQuadrado(View v) {
        //constante da tag de cada botão
        //ultilizamos essa constante para reculperar o botão atravez do metodo get quadrado

        if (!isFim()) {//verifica se o jogo acabou

            if (((Button) v).getText().equals(".")) {//verifica se o texto do botão é diferente de vazio

                if (getLastPlay().equals(XIS)) {//verifica se o ultimo valor jogado eh igual a x
                    ((Button) v).setText(BOLA);//joga bola
                    setLastPlay(BOLA);//seta lastPlay como bola
                } else {
                    ((Button) v).setText(XIS);//seta o texto do botão como x
                    setLastPlay(XIS);// seta o valor de lastPlay com x
                }

                // Toast.makeText(getView().getContext(), v.getTag().toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getView().getContext(), "Opa! escolha outro quadrado", Toast.LENGTH_SHORT).show();
            }//imprime uma mensagem que foi jogado

            isFim();//verifica se eh o fim
        }
        }

    public void setColorQuadrados(int btn, int colorX) {
        //recebe o numero pala var btn
        //passa a instancia da cor pela var colorX
        getQuadrado(btn).setTextColor(getResources().getColor(colorX));
        //recupera o botão e set o textColor com a cor passada pela var coloX
    }


    public void setColorBlack(){
        for(int i=1; i<=9; ++i){
            if(getQuadrado(i)!=null){
                setColorQuadrados(i, R.color.preto);//envia a cor prata para setColorQuadrado

            }
        }
    }


    public boolean isFim() {

        for (int x = 0; x <= 7; ++x) {//percorrer todas as condições definidas na matriz
            String s1 = getQuadrado(estadoFinal[x][0]).getText().toString();//passa pra s1 o valor da linha e da coluna a ser verificado
            String s2 = getQuadrado(estadoFinal[x][1]).getText().toString();
            String s3 = getQuadrado(estadoFinal[x][2]).getText().toString();
//verifica se eh diferente de "."

            if ((!s1.equals(".")) && (!s2.equals(".")) && (!s3.equals("."))) {

                if (s1.equals(s2) && (s2.equals(s3))) {//verifica a igualdade
                    // if(s1 == s2 == s3){

                    setColorQuadrados(estadoFinal[x][0], R.color.vermelho);//se verdadeiro aplica a cor vermelho
                    setColorQuadrados(estadoFinal[x][1], R.color.vermelho);
                    setColorQuadrados(estadoFinal[x][2], R.color.vermelho);

                    Toast.makeText(getView().getContext(), "Fim de jogo", Toast.LENGTH_SHORT).show();

                    return true;//retorna verdadeiro, sim o jogo acabou
                }
            }
        }

        return false;
    }





    public Button getQuadrado (int tagNum){//retorna o respectivo quadrado requerido pela var tagNum
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

        setEnableQuadrado(true); //ativa os quadrados
        setColorBlack(); // pinta de pretp
        limpaCampos(); //invoca o metodo para limpar os campos


        RadioButton rx = (RadioButton) getView().findViewById(R.id.rbx); // retorna a instancia do radioButton rbx e armazena na var rx
        RadioButton ro = (RadioButton) getView().findViewById(R.id.rbo);
//recupera radiobutton ro
        if(rx.isChecked()){ //verifica se rx esta checado
            setLastPlay(BOLA); //alterar o lastPlay para o inverso, jogando o inverso que estiver contido no lasPlay

        }else{
            if(ro.isChecked()){ //indica que o ultimo a jogar foi o XIS
                setLastPlay(XIS);
            }
        }
  }

    public void limpaCampos(){
        for(int i=1; i<=9; ++i){ //percorrer todos os botões
            if(getQuadrado(i)!=null){ //verifica se eh diferente de null
                getQuadrado(i).setText("."); //seta o texto como ponto, limpa campo
            }
        }
    }

    public void setEnableQuadrado(boolean b){
//recebe o numero do botão pela var btn
        //passa a instancia pela var colorX
        //recuperamos o botão e setamos o textColor com a cor
        for(int i=1;i<=9;++i){//percorre todos os itens
           if(getQuadrado(i)!=null){//verifica se o quadrado != null
               getQuadrado(i).setEnabled(b);//se for, passa o valor para o quadrado
           }
     }
  }
}








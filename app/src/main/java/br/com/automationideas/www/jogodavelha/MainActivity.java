package br.com.automationideas.www.jogodavelha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main, null);
       setView(getLayoutInflater().inflate(R.layout.activity_main, null));
       setContentView(getView());

    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }


}

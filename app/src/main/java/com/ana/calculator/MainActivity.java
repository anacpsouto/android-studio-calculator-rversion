package com.ana.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declarar variáveis
    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro,
            numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
            ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Iniciar componentes
        IniciarComponentes();

        // Listener de insets (ignora se não usares EdgeToEdge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Atribuir listener a todos os botões de uma vez
        Button[] allButtons = new Button[]{
                numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro,
                numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
                ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar
        };

        /*
        * if (b != null) b.setOnClickListener(this);
          b != null evita tentar usar um Button que não existe (evita NullPointerException).
          b.setOnClickListener(this) registra o listener de clique para esse botão.
          this é a instância atual de MainActivity (porque MainActivity implements View.OnClickListener).
          Ao registrar, você diz: “quando esse botão for clicado, chama onClick(View view) da minha Activity”.
        * */
        for (Button b : allButtons) {
            if (b != null) b.setOnClickListener(this);
        }
        if (backspace != null) backspace.setOnClickListener(this);
    }

    //Recuperar os ids que estao declarados no activity
    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    //Metodo para acrescentar uma expressao ao visor de cima.
    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){

        //Se o meu txtResultado estiver vazio, nos mudamos o TxtExpressao para vazio tambem.
        if(txtResultado.getText() != null && !txtResultado.getText().toString().isEmpty()){
            txtExpressao.setText("");
        }

        //Se o meu estado booleano limpar_dados estiver como true, nos vamos pegar o txtResultado e vamos limpar ele, deixando-o vazio.
        if(limpar_dados){
            txtResultado.setText("");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
        }
    }

    @Override
    public void onClick(View view) {
        // Se for o backspace (ImageView)
        if (view == backspace) {
            String s = txtExpressao.getText().toString();
            if (!s.isEmpty()) {
                txtExpressao.setText(s.substring(0, s.length() - 1));
            }
            return;
        }

        if (!(view instanceof Button)) return;

        String valor = ((Button) view).getText().toString();

        // Dígitos e ponto
        if (valor.matches("\\d") || valor.equals(".")) {
            AcrescentarUmaExpressao(valor, true);
            return;
        }

        // Operadores e comandos
        switch (valor) {
            case "+":
                AcrescentarUmaExpressao("+", false);
                break;
            case "-":
                AcrescentarUmaExpressao("-", false);
                break;
            case "X": // multiplicação
                AcrescentarUmaExpressao("*", false); // ou "X" se preferires
                break;
            case "/":
                AcrescentarUmaExpressao("/", false);
                break;
            case "C":
                txtExpressao.setText("");
                txtResultado.setText("");
                break;
            case "=":
                // Aqui entra a lógica de cálculo do resultado
                // Exemplo: txtResultado.setText("123");
                break;
        }
    }
}
package com.example.appaulasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    private static final String TAG = "App_aulaSp";
    private static final String PREF_NOME = "App_aulaSp_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Rodando");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        Log.i(TAG, "onCreate: Pasta Shared criada");

        // Editando os dados
        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.99f;
        estoque = true;

        // Salvando os dados
        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);

        // Criando o arquivo xml
        dados.apply();

        // Modo debug
        Log.i(TAG, "onCreate: Dados para serem Salvos");
        Log.w(TAG, "onCreate: Produto: "+ nomeProduto);
        Log.w(TAG, "onCreate: Código: "+ codigoProduto);
        Log.w(TAG, "onCreate: Preço: "+ precoProduto);
        Log.w(TAG, "onCreate: Tem no estoque: "+ estoque);

        /* Limpar os dados

        dados.clear();
        dados.apply(); */

        /* Remover dados individuais

        dados.remove("estoque");
        dados.apply(); */

        // Recuperar dados
        Log.i(TAG, "onCreate: Dados recuperados: ");

        Log.d(TAG, "onCreate: Produto: "+ sharedPreferences.getString("nomeProduto",
                "fora de estoque"));
        Log.d(TAG, "onCreate: Preco: "+ sharedPreferences.getFloat("precoProduto",
                -1.0f));
        Log.d(TAG, "onCreate: Codigo: " + sharedPreferences.getInt("codigoProduto",
                -1) );
        Log.d(TAG, "onCreate: Tem no estoque: "+ sharedPreferences.getBoolean("estoque",
                false));

    }
}
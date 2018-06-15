package grupo.merco;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SyncStateContract;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import grupo.merco.database.testeOpenHelper;

public class EUUUUUUUUAQUI extends AppCompatActivity {

    private SQLiteDatabase conexao;
  //  private testeOpenHelper TesteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_euuuuuuuuaqui);
   //     TesteOpenHelper = new testeOpenHelper(this);
        //TesteOpenHelper = (ConstraintLayout)findViewById(R.id.criaListaID);
    }
    private void criarConexao(){ // CRIANDO CONEXÃO DOS BD
       try{
     //      TesteOpenHelper = new testeOpenHelper(this);
       //    conexao = TesteOpenHelper.getWritableDatabase();
         //  Snackbar.make(TesteOpenHelper, "DEU");
       }
       catch(SQLException ex){
        }
    }

    //BOTOES PARA CHAMAR OUTRAS PAGINAS
    public void ChamabotaoMinhasListas(View v){
        Button btn = (Button)findViewById(R.id.Minhas_Listas);
        startActivity(new Intent(EUUUUUUUUAQUI.this,minhasLista.class));
    }
    public void ChamaBotaoCriarLista(View v){
        Button btn2 = (Button)findViewById(R.id.MAIS);
        startActivity(new Intent(EUUUUUUUUAQUI.this,criarLista.class));
    }

    public void ChamaBotaoTelaItem(View v){
        Button btn3 = (Button)findViewById(R.id.Item);
        startActivity(new Intent(EUUUUUUUUAQUI.this,telaItemMain.class));
    }

        // ----

    }
//trabalha a mill anos nisso/**/
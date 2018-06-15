package grupo.merco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.CollationElementIterator;

public class criarLista extends AppCompatActivity {

   public void addProduto(View view) {
        EditText editaNome = (EditText) findViewById(R.id.textoNome);
        EditText editaID = (EditText) findViewById(R.id.textoID);
        ajudanteDoBD ajudante = new ajudanteDoBD(this, null, null, 1);
        int id = Integer.parseInt(editaID.getText().toString());
        String name = editaNome.getText().toString();
        bdProduto produto = new bdProduto(id, name);
        ajudante.addData(name,id);
        Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
        editaNome.setText("");
        editaID.setText("");
  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);
        }
}

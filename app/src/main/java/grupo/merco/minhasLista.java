package grupo.merco;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class minhasLista extends AppCompatActivity {

    ajudanteDoBD meuAjudante;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_lista);
    }

    public void mostraDados(View view){
        ListView listView = (ListView) findViewById(R.id.listaDadosID);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(context, "DEU.", Toast.LENGTH_LONG).show();
            }
        });
        meuAjudante = new ajudanteDoBD(this,null,null,1);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = meuAjudante.getListContents();
        if(data.getCount()==0){
            Toast.makeText(minhasLista.this,"NAO",Toast.LENGTH_LONG).show();
        }else{
        while(data.moveToNext()) {
            theList.add(data.getString(1));
            LstViewAdapter listAdapter = new LstViewAdapter(this, R.layout.activity_minhas_lista,R.id.listaDadosID, theList);
//            LstViewAdapter adapter=new LstViewAdapter(this,R.layout.activity_listview_tela_item,R.id.txt,items);
            listView.setAdapter(listAdapter);
        }
            Toast.makeText(minhasLista.this,"FOI",Toast.LENGTH_LONG).show();
        }
//
//        ListView simpleslist;
//        String aList[] = {"Freddy", "gay", "zao"};
//        simpleslist = (ListView) findViewById(R.id.listaDadosID);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_listview,R.id.AQUI,aList);
//        simpleslist.setAdapter(arrayAdapter);
    }


    //    public void buttonOnClick(View v){
//
//        Button button=(Button)v;
//
//    }



//    public void loadStudents(View view) {
//        ListView listaDados = (ListView) findViewById(R.id.listaDadosID);
//        ajudanteDoBD dbHandler = new ajudanteDoBD(this, null, null, 1);
//        listaDados.setText(dbHandler.loadHanler());
//        listaDados.ListView("");
//        listaDados.ListView("");
//    }


}
//
//    public void loadStudents(View view) {
//        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
//        lst.setText(dbHandler.loadHanler());
//        studentid.setText("");
//        studentname.setText("");
//    }
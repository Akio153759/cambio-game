package com.tamadev.cambio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tamadev.cambio.classes.Card;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Card> _lstMasoDeCartas;
    private ArrayList<Card> _lstCartasMias;
    private TextView lblCartaUno, lblCartaDos, lblCartaTres, lblCartaCuatro, lblMasoVisible, lblAuxUno, lblAuxDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblCartaUno = findViewById(R.id.lblCartaUno);
        lblCartaDos = findViewById(R.id.lblCartaDos);
        lblCartaTres = findViewById(R.id.lblCartaTres);
        lblCartaCuatro = findViewById(R.id.lblCartaCuatro);
        lblMasoVisible = findViewById(R.id.lblMasoVisible);
        lblAuxUno = findViewById(R.id.lblAuxUno);
        lblAuxDos = findViewById(R.id.lblAuxDos);

        ArrayList<String> _lstCombinaciones = Card.getCombinacionesPosibles();
        _lstCartasMias = new ArrayList<>();
        _lstMasoDeCartas = new ArrayList<>();

        while (_lstCombinaciones.size() > 0){
            int _iIndex = (int) (Math.random() * (_lstCombinaciones.size()-1));

            Card _objCard = new Card();
            // con el indice obtenido anteriormente, recupero el valor en la lista de combinaciones y lo parseo para mapear el numero y el tipo
            _objCard.set_iNumber(Integer.parseInt(_lstCombinaciones.get(_iIndex).substring(0,_lstCombinaciones.get(_iIndex).indexOf("-"))));
            _objCard.set_iCardType(Integer.parseInt(_lstCombinaciones.get(_iIndex).substring(_lstCombinaciones.get(_iIndex).indexOf("-")+1)));
            _lstMasoDeCartas.add(_objCard);
            _lstCombinaciones.remove(_iIndex);
        }

        for (int i = 1; i <= 4; i++){
            _lstCartasMias.add(_lstMasoDeCartas.get(0));
            _lstMasoDeCartas.remove(0);
        }

        lblCartaUno.setText(String.valueOf(_lstCartasMias.get(0).get_iNumber()));
        lblCartaUno.setBackgroundColor(Color.parseColor(_lstCartasMias.get(0).getHexColorCardType()));

        lblCartaDos.setText(String.valueOf(_lstCartasMias.get(1).get_iNumber()));
        lblCartaDos.setBackgroundColor(Color.parseColor(_lstCartasMias.get(1).getHexColorCardType()));

        lblCartaTres.setText(String.valueOf(_lstCartasMias.get(2).get_iNumber()));
        lblCartaTres.setBackgroundColor(Color.parseColor(_lstCartasMias.get(2).getHexColorCardType()));

        lblCartaCuatro.setText(String.valueOf(_lstCartasMias.get(3).get_iNumber()));
        lblCartaCuatro.setBackgroundColor(Color.parseColor(_lstCartasMias.get(3).getHexColorCardType()));

    }
}
package matheus.fink.prep3_sequecia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNtermos;
    private TextView tvResul;

    private TextView tvValorInv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNtermos = findViewById(R.id.etNtermos);
        etNtermos.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvResul = findViewById(R.id.tvResul);
        tvResul.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvValorInv = findViewById(R.id.tvValorInv);
        tvValorInv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        TextView tvTitulo = findViewById(R.id.tvTitulo);
        tvTitulo.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        if (etNtermos.getText().toString().isEmpty()) {
            tvValorInv.setText("Campo vazio, digite novamente");
        } else {
            int Ntermos = Integer.parseInt(etNtermos.getText().toString());
            if (Ntermos < 1 || Ntermos > 19) {
                tvValorInv.setText("Valor inválido, digite novamente");
                etNtermos.setText("");
                tvResul.setText("");

            } else {

                etNtermos.setText("");
                tvValorInv.setText("");

                int pSeq = 1;
                int valorH = 0;
                for (int i = 1; i <= Ntermos; i++) {
                    if (i % 2 == 1) {
                        valorH = valorH + (i * pSeq);
                        pSeq++;
                    } else {
                        valorH = valorH + (i * pSeq);
                        pSeq--;
                    }
                }
                String res = "H = " + valorH;
                tvResul.setText(res);

            }
        }
    }
}
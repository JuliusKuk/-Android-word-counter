
package com.example.wordcounter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
                });

        EditText writtenText = findViewById(R.id.txtInputCounted);
        TextView wordCount = findViewById(R.id.txtViewWordCount);
        TextView numberCount = findViewById(R.id.txtViewNumberCount);
        TextView punctCount = findViewById(R.id.txtViewPunctuationCount);
        TextView sentCount = findViewById(R.id.txtViewSentenceCount);
        Button countButton = findViewById(R.id.btnCount);

        TextCounter textCounter = new TextCounter();

        countButton.setOnClickListener(v -> {
            String text = writtenText.getText().toString();

            if (text.trim().isEmpty()) {
                Toast.makeText(
                        MainActivity.this,
                        R.string.empty_text_error,
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            int words = textCounter.CountWords(text);
            int sentences = textCounter.CountSentences(text);
            int punctuation = textCounter.CountPunctuation(text);
            int numbers = textCounter.CountNumbers(text);

            wordCount.setText(getString(R.string.words_result, words));
            sentCount.setText(getString(R.string.sentences_result, sentences));
            punctCount.setText(getString(R.string.punctuation_result, punctuation));
            numberCount.setText(getString(R.string.numbers_result, numbers));
        });
    }
}

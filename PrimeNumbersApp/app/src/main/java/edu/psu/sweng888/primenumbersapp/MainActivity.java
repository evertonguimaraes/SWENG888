package edu.psu.sweng888.primenumbersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewTitle;
    private TextView mTextViewResult;
    private EditText mEditTextNumber;
    private Button mButtonCheckIfPrime;

    private Button mButtonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewTitle = findViewById(R.id.textViewTitle);
        mTextViewResult = findViewById(R.id.textViewResult);
        mEditTextNumber = findViewById(R.id.editTextNumber);
        mButtonCheckIfPrime = findViewById(R.id.buttonCheckIfPrime);
        mButtonDelete = findViewById(R.id.buttonDelete);

        /** Anomymous Listener */
        OnPrimeClickListener primeClickListener = new OnPrimeClickListener();
        mButtonCheckIfPrime.setOnClickListener(primeClickListener);
        mButtonDelete.setOnClickListener(primeClickListener);

    }

    private boolean isPrime(int number){
        if (number <= 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    private class OnPrimeClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonCheckIfPrime: checkIfPrime(); break;
                case R.id.buttonDelete: deleteContentFromView(); break;
                default: break;
            }
        }

        private void checkIfPrime(){
            // Get the text from the UI
            String numberString = mEditTextNumber.getText().toString();
            int number = Integer.parseInt(numberString);
            // Check if prime
            boolean isPrime = isPrime(number);
            // Display the results in the TextView
            mTextViewResult.setText(isPrime ? "isPrime" : "isNotPrime");
            mTextViewResult.setVisibility(View.VISIBLE);
        }

        private void deleteContentFromView(){
            mEditTextNumber.setText("");
            String msg = "The number was deleted";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
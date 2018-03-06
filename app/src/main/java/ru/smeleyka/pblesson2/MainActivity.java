package ru.smeleyka.pblesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_text)    EditText editText;
    @BindView(R.id.view_text)    TextView textView;
    protected Disposable editTextSubscr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        onEditTextChange();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!editTextSubscr.isDisposed()){
            editTextSubscr.dispose();
        }
    }

    private void onEditTextChange() {
        editTextSubscr = RxTextView.textChanges(editText)
                .subscribe(charSequence -> textView.setText(charSequence));
    }

}

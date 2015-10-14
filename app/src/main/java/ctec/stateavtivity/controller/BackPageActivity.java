package ctec.stateavtivity.controller;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import ctec.stateavtivity.R;

import ctec.stateavtivity.model.AndroidSaveState;

/**
 * Created by abro5723 on 10/14/15.
 */
public class BackPageActivity extends ActionBarActivity
{
    private AndroidSaveState saveState;
    private Button backButton;
    private TextView userText;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.backButton);
        userText = (TextView) findViewById(R.id.backText);

        loadContent();

        setupListeners();
    }

    private void loadContent()
    {
        userText.setText(saveState.getUserName() + " is " + saveState.getAge() + " years old and their tired status is " + saveState.getIsTired());
    }

    private void setupListeners()
    {
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}

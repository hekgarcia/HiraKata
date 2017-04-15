/**
 * BlissDynamic 2014.
 * 
 * This class represents the Main or principal Activity of the
 * application.
 * 
 * MainActivity.java
 * 
 * ChangeLog
 * ============================================================
 * Release Date	  Changed Date	Author   		Comment
 * 				  03/18/2014 	Hector Garcia	Born on
 * ============================================================
 */

package com.blissdynamic.hirakata;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.blissdynamic.hirakata.R.drawable;

public class MainActivity extends Activity {
	
	private static final String HIRAGANA_PREFIX = "hiragana_";
	
	
	HashMap<String,Integer> hiragana = new HashMap<String,Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeMemo();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * Verifies if the label value in the pressed button corresponds with 
     * the character displayed.
     * 
     * @param view The view which is the button pressed.
     */
    public void checkSelected(View view)
    {
    	Button b = (Button) view;
    	
    	String buttonText = b.getText().toString();
    }
    
    /**
     * This method initializes all required objects for the Hiragana memorizer.
     */
    private void initializeMemo()
    {
    	
    	initHiragana();
    	
    	ImageView charImage = (ImageView) findViewById(R.id.characterImage);
    	
    	Random random = new Random();
    	Integer randomN = random.nextInt(hiragana.size());
    	
    	String key = (String) hiragana.keySet().toArray()[randomN];
    	
    	
    	charImage.setImageResource(hiragana.get(key));
    	
    	
    }
    
    /**
     * This method initializes the hiragana HashMap with all the Hiragana characters.
     */
    private void initHiragana()
    {
    	AssetManager am = getResources().getAssets();
    	String[] drawablesArray = null;
    	try {
    		drawablesArray = am.list("res/drawables");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if (drawablesArray!=null)
    	{
    		for (String drawable: drawablesArray)
        	{
        		System.out.println(drawable);
        	}
    	}
    	
    	
    	hiragana.put(HIRAGANA_PREFIX + "a", drawable.custom_hiragana_a);
    	hiragana.put(HIRAGANA_PREFIX + "ha",drawable.custom_hiragana_ha);
    }
    
}

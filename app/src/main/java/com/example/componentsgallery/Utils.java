package com.example.componentsgallery;

import android.content.Context;
import android.content.Intent;

public class Utils {
    public static boolean openActivity(Context packageContext, Class<?> cls, String[] keys, String[] values){

        try {
            Intent myIntent = new Intent(packageContext, cls);

            if (keys != null && values != null) {
                if (keys.length != values.length) return false;
                for (int i = 0; i < keys.length; i++) {
                    try {
                        myIntent.putExtra(keys[i], values[i]);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            packageContext.startActivity(myIntent);

            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}

package com.example.tp06.Utils;

import android.widget.EditText;

public class ValidacionesHelpers {

    public static boolean esUnStringValido(EditText edtView){
        boolean blnRetornar = false;
        String strTexto;

        strTexto = edtView.getText().toString();
        blnRetornar = esUnStringValido(strTexto);

        return blnRetornar;
    }

    public static boolean esUnStringValido(String strTexto){
        boolean blnRetornar = false;
        blnRetornar = esUnStringValido(strTexto, 0);
        return blnRetornar;
    }

    public static boolean esUnStringValido(String strTexto, int intMinimoLetras){
        boolean blnRetornar = false;
        blnRetornar = esUnStringValido(strTexto, intMinimoLetras, 2147483647);
        return blnRetornar;
    }

    public static boolean esUnStringValido(String strTexto, int intMinimoLetras, int intMaximoLetras){
        boolean blnRetornar = false;

        if ((strTexto!=null) && (strTexto.trim().length()>=intMinimoLetras) &&(strTexto.trim().length()<=intMaximoLetras)){
            blnRetornar = true;
        }
        return blnRetornar;
    }
}

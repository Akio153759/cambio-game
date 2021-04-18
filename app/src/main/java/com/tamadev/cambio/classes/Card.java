package com.tamadev.cambio.classes;

import java.util.ArrayList;

public class Card {

    private int _iNumber;
    private int _iCardType;

    public Card(int _iNumber, int _iCardType) {
        this._iNumber = _iNumber;
        this._iCardType = _iCardType;
    }

    public Card() {
    }

    public int get_iNumber() {
        return _iNumber;
    }

    public void set_iNumber(int _iNumber) {
        this._iNumber = _iNumber;
    }

    public int get_iCardType() {
        return _iCardType;
    }

    public void set_iCardType(int _iCardType) {
        this._iCardType = _iCardType;
    }

    public String getCardType(){
        String _sCardTypeDescription = "";
        switch (_iCardType){
            case 1:
                _sCardTypeDescription = "Espada";
                break;
            case 2:
                _sCardTypeDescription = "Basto";
                break;
            case 3:
                _sCardTypeDescription = "Oro";
                break;
            case 4:
                _sCardTypeDescription = "Copa";
                break;
            default:
                _iCardType = 4;
                _sCardTypeDescription = "Copa";
                break;
        }

        return _sCardTypeDescription;
    }

    public static ArrayList<String> getCombinacionesPosibles(){
        ArrayList<String> _result = new ArrayList<>();

        // Con los cuatro palos
        for (int x = 1; x <= 4; x++) {
            // Combino los 12 diferentes numeros para armar el maso
            for (int i = 1; i <= 12; i++) {
                _result.add(i + "-" + x);
            }

        }

        return _result;
    }

    public String getHexColorCardType(){
        String _result;

        switch (_iCardType){
            case 1:
                _result = "#338FFF";
                break;
            case 2:
                _result = "#52FF33";
                break;
            case 3:
                _result = "#FFF533";
                break;
            case 4:
                _result = "#FF3333";
                break;
            default:
                _result = "";
                break;
        }

        return _result;
    }

    @Override
    public String toString() {
        return _iNumber + " de " + getCardType();
    }
}

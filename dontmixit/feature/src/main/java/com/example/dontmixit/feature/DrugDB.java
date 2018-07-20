package com.example.dontmixit.feature;

import java.util.HashMap;

public class DrugDB {

    private static final HashMap<String, Drug> db = new HashMap<>();

    public static Drug lookup(String id) {
        return db.get(id);
    }

    public static final Drug WARFARIN = new Drug("7844186629", "Warfrain", "TODO");
    public static final Drug DIFLUNISAL = new Drug("5438334516", "Diflunisal", "");
    public static final Drug PREDNISONE = new Drug("60041659823512", "Prednisone", "");
    public static final Drug AZITHROMYCIN = new Drug("60041658823512", "Azithromycin", "");


    static {
        WARFARIN.addInteraction()

        db.put(WARFARIN.id, WARFARIN);
        db.put(DIFLUNISAL.id,  DIFLUNISAL);
        db.put(PREDNISONE.id, PREDNISONE);
        db.put(AZITHROMYCIN.id, AZITHROMYCIN);
    }




}

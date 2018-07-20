package com.example.dontmixit.feature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InteractionDB {

    private final static Set<Interaction> interactions = new HashSet<>();

    static {
        interactions.add(new Interaction(DrugDB.WARFARIN, DrugDB.DIFLUNISAL, "Diflunisal may increase the anticoagulant activities of Warfarin."));
        interactions.add(new Interaction(DrugDB.PREDNISONE, DrugDB.DIFLUNISAL, "Either increases toxicity of the other by added drug effects."));
        interactions.add(new Interaction(DrugDB.PREDNISONE, DrugDB.WARFARIN, "Prednisone reduces the blood clotting effect of Warfarin and may risk increased bleeding."));
        interactions.add(new Interaction(DrugDB.AZITHROMYCIN, DrugDB.WARFARIN, "Azithromycin greatly increases the blot clotting effect of Warfarin."));
    }

    static List<Interaction> findInteractions(List<Drug> drugList) {
        List<Interaction> o = new LinkedList<>();
        for(Interaction i: interactions)
            if( drugList.contains(i.d1) && drugList.contains(i.d2) )
                o.add(i);
        return o;
    }







}

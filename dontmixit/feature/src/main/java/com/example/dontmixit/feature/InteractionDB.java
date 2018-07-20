package com.example.dontmixit.feature;

public class InteractionDB {

    public static final Interaction I1 =
            new Interaction(DrugDB.WARFARIN, DrugDB.DIFLUNISAL, "Diflunisal may increase the anticoagulant activities of Warfarin.");
    public static final Interaction I2 =
            new Interaction(DrugDB.PREDNISONE, DrugDB.DIFLUNISAL, "Either increases toxicity of the other by added drug effects.");
    public static final Interaction I3 =
            new Interaction(DrugDB.PREDNISONE, DrugDB.WARFARIN, "Prednisone reduces the blood clotting effect of Warfarin and may risk increased bleeding.");
    public static final Interaction I4 =
            new Interaction(DrugDB.AZITHROMYCIN, DrugDB.WARFARIN, "Azithromycin greatly increases the blot clotting effect of Warfarin.");


}

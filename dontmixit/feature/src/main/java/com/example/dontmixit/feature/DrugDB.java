package com.example.dontmixit.feature;

import java.util.HashMap;

public class DrugDB {

    private static final HashMap<String, Drug> db = new HashMap<>();

    public static Drug lookup(String id) {
        return db.get(id);
    }

    /************************************************************************/
    /*                      i   a m   s o   s o r r y                       */
    /************************************************************************/
    public static final Drug WARFARIN = new Drug("7844186629", "Warfrain", "Warfarin is an anticoagulant drug normally used to prevent blood clot formation as well as migration. Although originally marketed as a pesticide (d-Con, Rodex, among others), Warfarin has since become the most frequently prescribed oral anticoagulant in North America. Warfarin has several properties that should be noted when used medicinally, including its ability to cross the placental barrier during pregnancy which can result in fetal bleeding, spontaneous abortion, preterm birth, stillbirth, and neonatal death. Additional adverse effects such as necrosis, purple toe syndrome, osteoporosis, valve and artery calcification, and drug interactions have also been documented with warfarin use. Warfarin does not actually affect blood viscosity, rather, it inhibits vitamin-k dependent synthesis of biologically active forms of various clotting factors in addition to several regulatory factors.");
    public static final Drug DIFLUNISAL = new Drug("5438334516", "Diflunisal", "Diflunisal, a salicylate derivative, is a nonsteroidal anti-inflammatory agent (NSAIA) with pharmacologic actions similar to other prototypical NSAIAs. Diflunisal possesses anti-inflammatory, analgesic and antipyretic activity. Though its mechanism of action has not been clearly established, most of its actions appear to be associated with inhibition of prostaglandin synthesis via the arachidonic acid pathway. Diflunisal is used to relieve pain accompanied with inflammation and in the symptomatic treatment of rheumatoid arthritis and osteoarthritis.");
    public static final Drug PREDNISONE = new Drug("60041659823512", "Prednisone", "A synthetic anti-inflammatory glucocorticoid derived from cortisone. It is biologically inert and converted to prednisolone in the liver. ");
    public static final Drug AZITHROMYCIN = new Drug("60041658823512", "Azithromycin", "Azithromycin is a semi-synthetic macrolide antibiotic of the azalide class. Like other macrolide antibiotics, azithromycin inhibits bacterial protein synthesis by binding to the 50S ribosomal subunit of the bacterial 70S ribosome. Binding inhibits peptidyl transferase activity and interferes with amino acid translocation during the process of translation. Its effects may be bacteriostatic or bactericidal depending of the organism and the drug concentration. Its long half life, which enables once daily dosing and shorter administration durations, is a property distinct from other macrolides.");
    //This is an atrocity. Imagine it was a fancy HTTP POST request launched in an asynchronous thread


    static {

        db.put(WARFARIN.id, WARFARIN);
        db.put(DIFLUNISAL.id,  DIFLUNISAL);
        db.put(PREDNISONE.id, PREDNISONE);
        db.put(AZITHROMYCIN.id, AZITHROMYCIN);
    }




}

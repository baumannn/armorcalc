package bmnn.armorcalc;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Start extends AppCompatActivity {

    List<Head> heads = new ArrayList<>();
    List<Chest> chests = new ArrayList<>();
    List<Arms> armses = new ArrayList<>();
    List<Legs> legses = new ArrayList<>();

    TextView output;
    Boolean fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ArmorDataSource datasource = new ArmorDataSource(this);

        heads = datasource.getAllHeads();
        chests = datasource.getAllChests();
        armses = datasource.getAllArms();
        legses = datasource.getAllLegs();

        for (Head h : heads){
            Log.i("head" , h.getName());
        }
        for (Chest h : chests){
            Log.i("chest" , h.getName());
        }

        for (Arms a : armses){
            Log.i("arm" ,a.getName());
        }
        for (Legs l : legses){
            Log.i("leg" , l.getName());
        }

        NumberPicker np = (NumberPicker) findViewById(R.id.priority1);
        if(np != null) {
            np.setMinValue(0);
            np.setMaxValue(13);
            np.setDisplayedValues(new String[] {"None","Physical", "Strike", "Slash", "Thrust",
                    "Magic", "Fire", "Lightning", "Dark", "Bleed", "Poison", "Frost", "Curse", "Poise"});
        }

        NumberPicker np2 = (NumberPicker) findViewById(R.id.priority2);
        if(np2 != null) {
            np2.setMinValue(0);
            np2.setMaxValue(13);
            np2.setDisplayedValues(new String[] {"None","Physical", "Strike", "Slash", "Thrust",
                    "Magic", "Fire", "Lightning", "Dark", "Bleed", "Poison", "Frost", "Curse", "Poise"});
        }

        NumberPicker np3 = (NumberPicker) findViewById(R.id.average);
        if(np3 != null) {
            np3.setMinValue(0);
            np3.setMaxValue(1);
            np3.setDisplayedValues(new String[] {"Only consider priorities","Use all stats"});
        }

        output = (TextView) findViewById(R.id.results);

    }


    public void calculate(View v){
        double current = -1;
        double max = 0;
        int p1 = 0;
        int p2 = 0;
        boolean ave = true;

        fat = false;

        TextView tv = (TextView) findViewById(R.id.results);
        if (tv != null) {
            tv.setText("");
        }

        EditText e_current =  (EditText)findViewById(R.id.currentload);
        if(e_current != null) {
            current = Double.parseDouble(e_current.getText().toString());
        }

        EditText e_max =  (EditText)findViewById(R.id.maxload);
        if(e_max != null) {
            max = Double.parseDouble(e_max.getText().toString());
        }

        NumberPicker np_p1 =  (NumberPicker) findViewById(R.id.priority1);
        if(np_p1 != null) {
            p1 = np_p1.getValue();
        }

        NumberPicker np_p2 =  (NumberPicker) findViewById(R.id.priority2);
        if(np_p2 != null) {
            p2 = np_p2.getValue();
        }

        NumberPicker np_ave =  (NumberPicker) findViewById(R.id.average);
        if(np_ave != null) {
            ave = (np_ave.getValue()==1);
        }

//        search((.7 * max) - current, p1, p2);

        Params p = new Params();
        p.setWeight((.7 * max)-current);
        p.setP1(p1);
        p.setP2(p2);
        p.setAverage(ave);

        if(p.getWeight() < 0){
            fat = true;
            p.setWeight(max-current);
        }



        new searchAsync().execute(p);
//
//        Toast.makeText(Start.this, "OK" + current + " " + max + " " + p1 + " " + p2, Toast.LENGTH_SHORT).show();

    }



    private class searchAsync extends AsyncTask<Params,Void,Armor>{

        ProgressDialog pDialog;


        @Override
        protected void onPreExecute() {

            pDialog = new ProgressDialog(Start.this);
            pDialog.setMessage("Searching...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Armor doInBackground(Params... params) {

            double limit = params[0].getWeight();

            if(limit < 0 ) return null;

            for (Head h: heads){
                h.setValue(params[0].getP1(), params[0].getP2(), params[0].isAverage());
            }
            for (Chest c: chests){
                c.setValue(params[0].getP1(), params[0].getP2(), params[0].isAverage());
            }
            for (Arms a: armses){
                a.setValue(params[0].getP1(), params[0].getP2(), params[0].isAverage());
            }
            for (Legs l: legses){
                l.setValue(params[0].getP1(), params[0].getP2(), params[0].isAverage());
            }

            Armor best = new Armor();
            best.setHead(heads.get(0));
            best.setChest(chests.get(0));
            best.setArms(armses.get(0));
            best.setLegs(legses.get(0));

            Armor current = new Armor();

            current.setHead(heads.get(0));
            current.setChest(chests.get(0));
            current.setArms(armses.get(0));
            current.setLegs(legses.get(0));

            for (Head h: heads){

                current.setHead(h);
//                Log.i("checking head", h.getName());

                if(current.getHead().getValue() < best.getHead().getValue() && current.getHead().getWeight() > best.getHead().getWeight()){
                    //if current is heavier and worse than best, prune
//                    Log.e("prune", "head");
                    continue;
                }


                for (Chest c: chests){

                    current.setChest(c);
//                    Log.i("checking chest", c.getName());

                    if(current.getChest().getValue() < best.getChest().getValue() && current.getChest().getWeight() > best.getChest().getWeight()){
                        //if current is heavier and worse than best, prune
//                        Log.e("prune", "chest");
                        continue;
                    }

                    for ( Arms a: armses){

                        current.setArms(a);
//                        Log.i("checking arms", a.getName());
                        if(current.getArms().getValue() < best.getArms().getValue() && current.getArms().getWeight() > best.getArms().getWeight()){
                            //if current is heavier and worse than best, prune
//                            Log.e("prune", "arms");
                            continue;
                        }

                        for (Legs l: legses){

                            current.setLegs(l);
//                            if(current.getLegs().getValue() < best.getLegs().getValue() && current.getLegs().getWeight() > best.getLegs().getWeight()){
//                                //if current is heavier and worse than best, prune
//                                Log.i("prune", "legs");
//                                continue;
//                            }
//
//                            Log.i("weight", current.get(14)+"");
//                            Log.i("current", current.get(p1)+"");
//                            Log.i("best", best.get(p1)+"");

                            if(current.get(14) <= limit && current.get(0) > best.get(0)){
                                Log.i("current vs limit", current.get(14) + " " + limit);
                                //if set is wearable and better than current best, replace set

                                best.setHead(current.getHead());
                                best.setChest(current.getChest());
                                best.setArms(current.getArms());
                                best.setLegs(current.getLegs());

                                Log.e("new", best.getHead().getName() +" " + best.getChest().getName()
                                        + " "+ best.getArms().getName()+" " + best.getLegs().getName() + " " + best.get(0) + " " + best.get(14));
//                                setBest(best);

                            }



                        }
                    }
                }

            }

            Log.i("completed", "search");
//            runOnUiThread(new Runnable() {
//                public void run() {
//
//                    Toast.makeText(Start.this, "DONE", Toast.LENGTH_SHORT).show();
//                    //Do something on UiThread
//                }
//            });


            return best;
        }

        @Override
        protected void onPostExecute(Armor armor) {

            pDialog.dismiss();
            if(armor!= null) {
                output.setText(armor.getHead().getName() + "\n" + armor.getChest().getName() + "\n" + armor.getArms().getName() + "\n" + armor.getLegs().getName());
                if(!fat){
                    Toast.makeText(Start.this, "DONE", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Start.this, "FAT!", Toast.LENGTH_SHORT).show();
                }
            } else{
                Toast.makeText(Start.this, "OVERWEIGHT!!", Toast.LENGTH_SHORT).show();
            }

        }


    }

//    private void search(double limit, int p1, int p2){
//
//        if(limit <=0 ) return;
//
//        Armor best = new Armor();
//        best.setHead(heads.get(0));
//        best.setChest(chests.get(0));
//        best.setArms(armses.get(0));
//        best.setLegs(legses.get(0));
//
//        Armor current = new Armor();
//
//        for (Head h: heads){
//
//            current.setHead(h);
//
//            for (Chest c: chests){
//
//                current.setChest(c);
//
//                for ( Arms a: armses){
//
//                    current.setArms(a);
//
//                    for (Legs l: legses){
//
//                        current.setLegs(l);
//
//                        if(current.get(14) <= limit) {
//
//                            if ( current.get(p1) > best.get(p1)){
//
//                                best = current;
//                                Log.i("new", best.getHead().getName() +" " + best.getChest().getName()
//                                        + " "+ best.getArms().getName()+" " + best.getLegs().getName() + " " + best.get(14));
//                                setBest(best);
//
//                            }
//                        }
//
//                    }
//                }
//            }
//
//        }
//
//
//
//
//




//    }


}

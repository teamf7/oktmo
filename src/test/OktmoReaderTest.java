package test;

import oktmo.OktmoData;
import oktmo.OktmoReader;
import oktmo.Place;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by designAi on 20.10.2016.
 */
public class OktmoReaderTest {
    OktmoData data;
    OktmoData data2;
    OktmoReader reader;
    public OktmoReaderTest(){
        data = new OktmoData();
        data2 = new OktmoData();
        reader = new OktmoReader();
    }/*
    @Test
    public void readPlaces() throws Exception {
      //  reader.readPlaces("task/tom5_oktmo_2.csv",data);
    }

    @Test
    public void readPlacesRegEx() throws Exception {
     //   reader.readPlacesRegEx("task/tom5_oktmo_2.csv",data2);
    }*/

    @Test
    public void equalsPlaces() throws Exception {
        reader.readPlaces("task/tom5_oktmo_2.csv",data);
        reader.readPlacesRegEx("task/tom5_oktmo_2.csv",data2);

        int len1 = data.getList().size();
        int len2 = data2.getList().size();
        System.out.println(len1+" " +len2);

        for(int i = --len2,j=--len1; i > 10000; i--,j--){
            System.out.println(data2.getPlace(i).getName()+" "+i);
            System.out.println(data.getPlace(j).getName()+" " + j);
        }
       // assertEquals(f,f1);

    }

}
package oktmo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by designAi on 18.10.2016.
 */
public class OktmoData {
    private List<Place> list;
    Set<String> allStatus;
    List<Place> sortedPlaces;

    public OktmoData(){
        list = new LinkedList<>();
        allStatus = new HashSet<>();
    }

    public void setSortedPlaces(){
       sortedPlaces = new ArrayList<>(list);
         Collections.sort(sortedPlaces, new SortedByName());
    }


    public void addStatus(String status) {
        allStatus.add(status);
    }

    public void addPlace(Place place){
        list.add(place);
    }

    public void printSorted(){
        for(Place p: sortedPlaces){
            System.out.println("Название: " + p.getName()+" Код: "+p.getCode());
        }
    }
    public void printStatus(){
        for(Place p: list){
            System.out.println("Cтатус: "+p.getStatus());
        }
    }
    public void print(){
        for(Place places: list){
            System.out.println("Kод: " +places.getCode() + " Название: " + places.getName() + " Статус " + places.getStatus());
        }
    }

    public List getList(){
        return list;
    }
    public Place getPlace(int i){
        return list.get(i);
    }

    public ArrayList findPlaceWithFirstAndEnd(){
        ArrayList findPlace = new ArrayList();//(aaa|bbb)[0-9]+\1
        Pattern p = Pattern.compile("^([б-джзк-нп-тф-щ])([a-я]*)\\1$", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m;

        for(Place place : list){
            m = p.matcher(place.getName());

            if(m.find()){
                findPlace.add(place);
            }
        }

        return findPlace;
    }

    public List findPlaceWithOva(){
        Pattern p = Pattern.compile("^[А-Яа-я0-9ёI«». -]{3}ова$");
        ArrayList findList = new ArrayList();
        Matcher m;
        for(int i = 0;i<list.size();i++){
            m = p.matcher(list.get(i).getName());
            if(m.find()){
                findList.add(list.get(i));
            }
        }
        return findList;
    }

}

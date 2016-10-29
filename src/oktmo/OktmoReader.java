package oktmo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by designAi on 18.10.2016.
 */
public class OktmoReader {

    public void readPlaces(String fileName, OktmoData data){
        BufferedReader br = null;
        long code;
        String name;
        String status=null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
            String s;
            while ((s=br.readLine()) !=null ) {
                String[] parameters = s.split(";");
                try {

                    if (parameters.length==3 && !(parameters[2].startsWith("Населенные пункты") || parameters[2].startsWith("Муниципальные районы"))) {
                        try {
                            parameters[0] = parameters[0].replace(" ", "");
                            code = Long.parseLong(parameters[0]);



                            int leng = parameters[2].indexOf(" ");
                            if(leng!=-1){
                                status = parameters[2].substring(0,leng);
                                data.addStatus(status);
                                name = parameters[2].substring(++leng);

                                data.addPlace(new Place(code, name, status));
                            }


                        } catch (NumberFormatException e) {
                            //System.out.println(e);
                        }
                    }
                }catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println(status);
                    System.out.println(ex.getSuppressed() +"" );
                }

            }
        }
        catch (IOException ex) {
            System.out.println("Reading error in line ");
            ex.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Can not close");
            }
        }
    }


    public void readPlacesRegEx(String fileName, OktmoData data) {
        BufferedReader br = null;

           try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf8"));
            String s;
            Pattern p;
            p = Pattern.compile("^(\\d{2}.\\d{3}.\\d{3}.\\d{3});\\d+;([а-я-/]{0,7}.?(платформа|будка|ж/д|казарма|[а-я]{1,3})?) ([А-Яа-я-ёI«»0-9'\"()№. -–I]+)$");

            while ((s=br.readLine()) !=null ) {
                Matcher m = p.matcher(s);

                if (m.matches()) {
                    String codeString = m.group(1).replace(" ", "");
                    long code = Long.valueOf(codeString);
                    String status = m.group(2);
                    String name = m.group(4);
                    data.addStatus(status);
                    data.addPlace(new Place(code, name, status));
                }
                //if (lineCount==40000) break; // пока частично

            }
        }
        catch (IOException ex) {
            System.out.println("Reading error in line ");
            ex.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Can not close");
            }
        }
    }

}

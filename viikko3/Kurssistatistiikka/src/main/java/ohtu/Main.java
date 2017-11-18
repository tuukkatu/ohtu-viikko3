package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        String kurssiUrl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String kurssiBodyText = Request.Get(kurssiUrl).execute().returnContent().asString();
        //System.out.println(kurssiBodyText);
        KurssiSubmission kurssiSub = mapper.fromJson(kurssiBodyText, KurssiSubmission.class);
        
//        String palautuksetUrl = "https://studies.cs.helsinki.fi/ohtustats/stats";
//        String statsResponse = Request.Get(palautuksetUrl).execute().returnContent().asString();
//        JsonParser parser = new JsonParser();
//        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
//        System.out.println(parsittuData);
        
        System.out.println(kurssiSub);
        System.out.println("");
        System.out.println("opiskelijanumero: "+studentNr);
        System.out.println("");
        //System.out.println("Oliot:");
        for (Submission submission : subs) {
            System.out.println(submission);
        }
        System.out.println("");
        
        int exerciseSum = 0;
        int hourSum = 0;
        for (Submission sub : subs) {
            exerciseSum += sub.getExercices().length;
            hourSum += sub.getHours();
        }
        System.out.println("yhteensä: " + exerciseSum + " tehtävää " + hourSum + " tuntia");
    }
}
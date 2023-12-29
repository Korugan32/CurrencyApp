import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ApiConnection {

    public double getCur1Value(String cur1) throws IOException {
        if (!cur1.equals("YTL")) {
            LocalDate bugun = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String bugununTarihi = bugun.format(formatter);
            double curValue = 0;
            try {
                URL apiUrl = new URL("https://evds2.tcmb.gov.tr/service/evds/series=TP.DK." + cur1 + ".A.YTL&startDate=" + bugununTarihi + "&endDate=" + bugununTarihi + "&type=json&key=1XT21TgOLo");
                HttpURLConnection connect = (HttpURLConnection) apiUrl.openConnection();
                if (connect.getResponseCode() != 200) {
                    throw new RuntimeException("An server error: " + connect.getResponseCode());
                }
                InputStreamReader iStream = new InputStreamReader(connect.getInputStream());
                BufferedReader bReader = new BufferedReader(iStream);
                Gson gson = new Gson();
                JsonObject jsonOb = gson.fromJson(bReader, JsonObject.class);
                JsonElement result = jsonOb.get("items");
                JsonArray jsonArray = result.getAsJsonArray();
                JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                String value = jsonObject.get("TP_DK_" + cur1 + "_A_YTL").getAsString();
                curValue = Double.parseDouble(value);
            } catch (IOException error) {
                error.printStackTrace();
            }
            return curValue;
        }else return 1;
    }
    public double getCur2Value(String cur1) throws IOException {
        if (!cur1.equals("YTL")) {
            LocalDate bugun = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String bugununTarihi = bugun.format(formatter);
            double curValue = 0;
            try {
                URL apiUrl = new URL("https://evds2.tcmb.gov.tr/service/evds/series=TP.DK." + cur1 + ".A.YTL&startDate=" + bugununTarihi + "&endDate=" + bugununTarihi + "&type=json&key=1XT21TgOLo");
                HttpURLConnection connect = (HttpURLConnection) apiUrl.openConnection();
                if (connect.getResponseCode() != 200) {
                    throw new RuntimeException("An server error: " + connect.getResponseCode());
                }
                InputStreamReader iStream = new InputStreamReader(connect.getInputStream());
                BufferedReader bReader = new BufferedReader(iStream);
                Gson gson = new Gson();
                JsonObject jsonOb = gson.fromJson(bReader, JsonObject.class);
                JsonElement result = jsonOb.get("items");
                JsonArray jsonArray = result.getAsJsonArray();
                JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                String value = jsonObject.get("TP_DK_" + cur1 + "_A_YTL").getAsString();
                curValue = Double.parseDouble(value);
            } catch (IOException error) {
                error.printStackTrace();
            }
            return curValue;
        }else return 1;
    }

}

package PaySky.QC.ApiRequest;

import PaySky.QC.Configuration.Config;
import PaySky.QC.Utilites.TestData.Constant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class GenerateQrRequest {


    public static Response generateQr() {

            JSONObject data = new JSONObject();
            data.put("merchantName", Constant.MerchantName);
            data.put("merchantMSISDN", Constant.MerchantMobileNumber);
            data.put("countryCode", Constant.CountryCode);

            // Make API request
            Response response = RestAssured.given().log().all()
                    .header("Content-Type", "application/json")
                    .body(data.toString())
                    .post(Config.BaseUrl + Config.GenerateQrEndPoint);


            // Log the response for debugging
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            return response;
        }


        public static String generateQrUrl(){
        Response response = generateQr();
        String QrUrl = response.jsonPath().getString("data.qrUrl");

        return QrUrl;
        }
    }


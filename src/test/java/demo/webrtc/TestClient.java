package demo.webrtc;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import demo.webrtc.utils.Constants;

/**
 * Created by kantipud on 07-01-2018.
 */
public class TestClient {

    public static String mediaUrl = "rtsp://10.142.138.216/z3-1.mp4";
    public static String clientHost = "10.142.149.35";
    public static String deviceId = "HPCAM27682CAM1";
    public static String missionId = "110100101";
    public static String useEncodedMedia = "true";
    public static String networkCache = "0";

    public static void main(String args[]) throws UnirestException {
        //postMediaInfo();
        createRTPEndpoint();
    }

    public static void postMediaInfo() throws UnirestException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"" + Constants.RTSP_URL + "\":");
        jsonBuilder.append("\"" + mediaUrl + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.MISSION_ID_JSONKEY + "\":");
        jsonBuilder.append("\"" + missionId + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.DEVICE_ID_JSONKEY + "\":");
        jsonBuilder.append("\"" + deviceId + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.USE_ENCODED_MEDIA + "\":");
        jsonBuilder.append("\"" + useEncodedMedia + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.CLIENT_HOST + "\":");
        jsonBuilder.append("\"" + clientHost + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.NETWORK_CACHE + "\":");
        jsonBuilder.append("\"" + networkCache + "\"");
        jsonBuilder.append("}");
        HttpResponse<String> jsonResponse = Unirest.post("http://localhost:9876/updatemediainfo")
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .body(jsonBuilder.toString())
                .asString();
        System.out.println("notifyFFMPEGTaskHandler replied for rtspUrl {} as status {} body {} " + mediaUrl + "  \n " + jsonResponse.getStatusText() + "  \n " +jsonResponse.getBody() != null ? jsonResponse.getBody().toString() : "");
    }

    public static void createRTPEndpoint() throws UnirestException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"" + Constants.RTSP_URL + "\":");
        jsonBuilder.append("\"" + mediaUrl + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.MISSION_ID_JSONKEY + "\":");
        jsonBuilder.append("\"" + missionId + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.DEVICE_ID_JSONKEY + "\":");
        jsonBuilder.append("\"" + deviceId + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.CLIENT_HOST + "\":");
        jsonBuilder.append("\"" + clientHost + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.USE_ENCODED_MEDIA + "\":");
        jsonBuilder.append("\"" + useEncodedMedia + "\"");
        jsonBuilder.append(",");
        jsonBuilder.append("\"" + Constants.NETWORK_CACHE + "\":");
        jsonBuilder.append("\"" + networkCache + "\"");
        jsonBuilder.append("}");
        HttpResponse<String> jsonResponse = Unirest.post("http://localhost:9876/creatertpendpoint")
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .body(jsonBuilder.toString())
                .asString();
        System.out.println("notifyFFMPEGTaskHandler replied for rtspUrl {} as status {} body {} " + mediaUrl + "  \n " + jsonResponse.getStatusText() + "  \n " +jsonResponse.getBody() != null ? jsonResponse.getBody().toString() : "");
    }
}

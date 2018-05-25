
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import java.io.FileInputStream;
import java.util.concurrent.CountDownLatch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romikavinda
 */
public class FCM {
    public static void main(String[] args) {
        
        //try{
        try{
            FileInputStream serviceAccount = new FileInputStream("PATH to Console Generated FCM ADMIN Private key JSON FILE");
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://EXAMPLE_PROJECT.firebaseio.com")
                .setProjectId("PROJECT_NAME")
                .build();


            FirebaseApp.initializeApp(options);
        }catch(Exception e){
      
        }
            
        
        System.out.println("initialized");
            // This registration token comes from the client FCM SDKs.
        String registrationToken = "CLIENT GENERATED TOKEN ( FROM AN ANDROID APP -ETC)";

        // See documentation on defining a message payload.
        Message message = Message.builder()
            .putData("title", "Hello")
            .putData("body", "World")
            .setToken(registrationToken)  /** CHOOSE EITHER seToken (For Sending to single device) or setTopic method
            //.setTopic("Test")
            .build();
        System.out.println("message built");


        try{

            String response = FirebaseMessaging.getInstance().sendAsync(message).get();
            System.out.println("message sent");
            System.out.println("Successfully sent message: " + response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}

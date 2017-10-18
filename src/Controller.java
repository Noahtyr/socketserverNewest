import com.sun.prism.impl.shape.OpenPiscesPrismUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;


public class Controller {

    @FXML
    public Button sendMsg;
    @FXML
    public TextArea chatWindow;
    @FXML
    public TextField text;
    @FXML
    public Button count;


    public Socket s;
    public OutputStream oPut;
    public InputStream iPut;
    public PrintWriter pw;
    private Scanner scan;
    private int counter = 0;
    private int oldCounter = 0;


    public void buttonPress(ActionEvent event){

        try{
            s = new Socket("127.0.0.1", 8080);
            chatWindow.appendText("User has logged in" + "\n");

        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
    @FXML
    public void send() {
        try {
            String message = text.getText();
            message = "" + message;
            chatWindow.appendText("\n"+message +"\n" );
            InputStream input = s.getInputStream();
            OutputStream output = s.getOutputStream();
            PrintWriter out = new PrintWriter(output,true);
            out.println(message);



        } catch (Exception ex){
            ex.printStackTrace();



            }
        }


   @FXML
    public void count() {
        try {
            iPut = s.getInputStream();
            oPut = s.getOutputStream();
            scan = new Scanner(iPut);
            pw = new PrintWriter(oPut, true);

        }catch (Exception e) {
            e.printStackTrace();
        }

        pw.println("COUNT");
        chatWindow.appendText(scan.nextLine() + " \n");
        if (oldCounter != counter) {
            for (int i = oldCounter; i < counter; i++) {
                chatWindow.appendText(scan.nextLine() + " \n");
            }
        }
        oldCounter = counter;


    }






    @FXML
    public void count(ActionEvent actionEvent) {
    }
}


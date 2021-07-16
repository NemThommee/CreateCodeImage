/**
 * Nos ide kell majd leírás ...
 * dokumentációs célzattal... 
 */

package hu.ntc_studio.CodeImage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXCreateImage extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button btOk = new Button("Jól van");
		btOk.setPrefSize(10, 80);

		primaryStage.setTitle("Teszt ablak, remélem jól kezeli az őőőő ékezetes betűket");
		primaryStage.setScene(new Scene(btOk, 450, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

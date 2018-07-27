import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Arrays;
 
public class GUI extends Application {
    static boolean[][] boolmtx = new boolean[7][5];
    static Button[][] buttons = new Button[7][5];
    static float[][] input = new float[7][5];
    static float[] inTest = new float[35];
    static NeuralNetwork nn;

    static String[] letter = {"A","B","C","D","E","F","G","H","I","J",
            "k","L","M","N","O","P","Q","R","S","T",
            "U","V","W","X","Y","Z"};
    
    // Function to make GUI's input compat with NN input.
    public static void writeInput() {
        int index = 0;
        for(int row=0; row<7; row++){
            for(int col=0; col<5; col++){
            	inTest[index] = input[row][col];
            	++index;
            }
        }
    }
    
    // Creates the input matrix on the GUI.
    public Button buttonCreate(double x, double y, double width, double height,
        int xpos, int ypos){
        Button butt = new Button();
        butt.setLayoutX(x);
        butt.setLayoutY(y);
        butt.setMinWidth(width);
        butt.setMinHeight(height);
        butt.setStyle("-fx-background-color: white;");
        butt.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override //button action on click
            public void handle(ActionEvent event) {
                if(boolmtx[xpos][ypos] == false) butt.setStyle("-fx-background-color: black;");
                else butt.setStyle("-fx-background-color: white;");
                boolmtx[xpos][ypos] = !boolmtx[xpos][ypos];
            }
        });
        return butt;
    }
    
    // Get the top 3 recognized values for our input. 
    private static int[] letterResult(NeuralNetwork nn, float[] a) {
        int[] b = new int[3];
        float[] copy = Arrays.copyOf(a, 26);
    	float max = 0.0f;
    	int maxIndex = 0;
    	for(int j = 0; j < 3; ++j) {
    	    max = copy[0];
            maxIndex = 0;
            for (int i = 0; i < 26; i++) {
                if (copy[i] > max) {
                    max = copy[i];
                    maxIndex = i;
                }
            }
            b[j] = maxIndex;
            copy[maxIndex] = Integer.MIN_VALUE;
        }
    	return b;
    }
    
    // Main: gets trained nn and starts the GUI.
    public static void main(String[] args) {
    	TrainedNeuralNet main = new TrainedNeuralNet();
        nn = main.getTrainedNn();
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Magic AI Letter Guesser");
        
        //==================Button-Properties=============
        // Guess letter button properties.
        Button btn = new Button();
        btn.setText("Click to Guess Letter");
        btn.setLayoutX(400); //setting button location
        btn.setLayoutY(350);
        btn.setMaxWidth(200);

        // Output list properties.
        ListView<String> list = new ListView<String>();
        list.setPrefWidth(100);
        list.setPrefHeight(70);
        list.setLayoutX(400);
        list.setLayoutY(275);

        // Clear button properties.
        Button clr = new Button();
        clr.setText("Click to clear the grid");
        clr.setLayoutX(400); 
        clr.setLayoutY(380);
        clr.setMaxWidth(200);

        //=======================Button-Actions===================
        // Reset input matrix colors.
        clr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int row=0; row<7; row++) {
                    for (int col = 0; col < 5; col++) {
                        buttons[row][col].setStyle("-fx-background-color: white;");
                        boolmtx[row][col] = false;
                    }
                }
            }
        });

        // Guess letter buttons actions.
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                for(int row=0; row<7; row++){												// Flips this buttons value.
                    for(int col=0; col<5; col++){
                        if(boolmtx[row][col]) input[row][col] = 1f;
                        else input[row][col] = 0f;
                    }
                }
                writeInput();																// Get compatible input for the NN.
 
                float[] predict = nn.fordprop(inTest);										// Pass input to trained neural net and get our results.
                int[] a = letterResult(nn, predict);										// Get top 3 results.

                ObservableList<String> items = FXCollections.observableArrayList (			// Make list of top 3 results to attach to GUI.
                        letter[a[0]]+"   "+(int)(predict[a[0]]*100)+"%.", letter[a[1]]+
                        "   "+(int)(predict[a[1]]*100)+"%.", letter[a[2]]+"   "+
                        (int)(predict[a[2]]*100)+"%.");

                list.setItems(items);
            }
        });
                
        Pane root = new Pane(); 															// Set pane.
        
        // Make matrix of buttons for user input on the GUI.
        for(int row=0; row<7; row++){
            for(int col=0; col<5; col++){
                buttons[row][col] = new Button();
                buttons[row][col] = buttonCreate(75+50*col, 75+50*row, 50, 50, row, col);
                root.getChildren().add(buttons[row][col]); //adding button to pane
            }
        }
        
        // Matrix of bools for user input. 
        for(int row=0; row<7; row++){
            for(int col=0; col<5; col++){
                boolmtx[row][col] = false;
            }
        }
        
        // Attach everything to the GUI.
        root.getChildren().add(list);
        root.getChildren().add(btn);
        root.getChildren().add(clr);
        primaryStage.setScene(new Scene(root, 625, 525));
        primaryStage.show();
    }
}
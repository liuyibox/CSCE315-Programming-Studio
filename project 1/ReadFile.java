import java.util.*;
import java.io.*;

// Read our training data from our file.
class ReadFile {
    float[][] inputData = new float[26][35];
    
    public float[][] readStuff(String fileName) {
        try {
        	Scanner scan = new Scanner(new File(fileName));
        	for(int i = 0; i < 26; i++) {
        		for(int j = 0; j < 35; j++) {        			
        			inputData[i][j] = scan.nextInt();       			
        		}
        	}
        	scan.close();
        }
        catch(Exception e) {
            System.out.println("Could not read file");
        }
        return inputData;
    }
}

class TrainedNeuralNet {
	
	private static float[][] inData;                                               
    private static float[][] outData;

    // Generates training data.
	public static void trainingData() {                                         
        ReadFile readData = new ReadFile();
        inData = readData.readStuff("training2.txt");   // Get training data.
        outData = new float[26][26];											     // Get expected outputs.
        for(int i = 0; i < 26; ++i) {
            outData[i][i] = 1f;                                          
        }
    }
	
	// Train our neural network.
  	public NeuralNetwork getTrainedNn() {
    	trainingData();		
    	int numLayers = 2;
    	NeuralNetwork nn = new NeuralNetwork(numLayers);
    	for(int i = 0; i < 700; ++i) {
    		for(int j = 0; j < 26; j++) {								// For each training example,  			
    			nn.fordprop(inData[j]);									// Calculate weighted sums & activation/output values.
		        Train train = new Train(nn, inData[j], outData[j]);
				train.backprop();	      								// Train weights.
    		}
        }
    	return nn;
    }
}
    		

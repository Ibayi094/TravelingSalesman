import java.io.IOException;

/**
 * Rockville -> Silver Spring -> Baltimore -> Philadelphia 
 * -> New York City -> Pittsburgh -> Cleveland -> Rockville
 * 
 * 0->13->34->106->97->370->133->352 = 1,105
 * 
 * Rockville -> Pittsburgh -> Cleveland -> New York City -> Philadelphia -> Baltimore -> Silver Spring -> Rockville
 * 0 -> 3 -> 5 -> 6 -> 2 -> 4 -> 1 -> 0
 * 
 * @author Chris Bonilla, Amir Nouraie, Melissa Bayigamba
 *
 */

public class TravelingSalesman {
	
	/**
	 * Program to calculate optimal route for tour using Nearest Neighbor and Custom Algorithm
	 * @param args
	 */
	public static void main(String[] args)
	{
		try {
			DataHandler givenDataSet = new DataHandler();
			givenDataSet.prepareTestData();
			//givenDataSet.collectData();
			givenDataSet.findShortestPathUsingNearestNeighborAlgorithm();
			givenDataSet.printNearestNeighborRoute();
			givenDataSet.printNearestNeighborRouteStats();
			givenDataSet.findShortestPathUsingCustomAlgorithm();
			givenDataSet.printCustomAlgorithmRoute();
			givenDataSet.printCustomAlgorithmRouteStats();
			
			DataHandler customAlgorithDataSet = new DataHandler();
			customAlgorithDataSet.prepareCustomAlgorithmTestData();
			//customAlgorithDataSet.collectData();
			customAlgorithDataSet.findShortestPathUsingNearestNeighborAlgorithm();
			customAlgorithDataSet.printNearestNeighborRoute();
			customAlgorithDataSet.printNearestNeighborRouteStats();
			customAlgorithDataSet.findShortestPathUsingCustomAlgorithm();
			customAlgorithDataSet.printCustomAlgorithmRoute();
			customAlgorithDataSet.printCustomAlgorithmRouteStats();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
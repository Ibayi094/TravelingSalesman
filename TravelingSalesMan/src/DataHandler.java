import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that holds all data for program.
 * It manipulates all the data, finding optimal route using Nearest Neighbor Algorithm as well as a custom algroithm.
 * @author Chris Bonilla, Amir Nouraie, Melissa Bayigamba
 *
 */

public class DataHandler {
	
	// Data Handler Fields
	
	/**
	 * Number of Cities Toured
	 */
	private int NumCities;
	
	/**
	 * Name of Cities Toured
	 */
	private String[] Cities;
	
	/**
	 * Distance from city to city
	 */
	private int[][] Distances;

	/**
	 * Route Data for route calculated using Nearest Neighbor Algorithm
	 */
	private RouteStats NearestNeighborRoute;
	
	/**
	 * Route Data for route calculated using Custom Algorithm
	 */
	private RouteStats CustomAlgorithmRoute;
	
	private ArrayList<Integer> PrevStarts = new ArrayList<>();
	
	/**
	 * Basic constructor to initialize class
	 */
	public DataHandler()
	{
		// Initialize Fields
		NearestNeighborRoute = new RouteStats();
		CustomAlgorithmRoute = new RouteStats();
	}
	
	/**
	 * Used to prepare test data given
	 */
	public void prepareTestData()
	{
		// FOR FAST TESTING - HARDCODED DATA
		NearestNeighborRoute.NumCities = CustomAlgorithmRoute.NumCities = NumCities = 7;
		Cities = new String[NumCities];
		Distances = new int[NumCities][NumCities];
		// Populate the names of the cities
		Cities[0] = "Rockville";
		Cities[1] = "Silver Spring";
		Cities[2] = "Philadelphia";
		Cities[3] = "Pittsburgh";
		Cities[4] = "Baltimore";
		Cities[5] = "Cleveland";
		Cities[6] = "New York City";

		// Populate distance from Rockville to other cities
		Distances[0][0] = 0;
		Distances[0][1] = 13;
		Distances[0][2] = 142;
		Distances[0][3] = 225;
		Distances[0][4] = 40;
		Distances[0][5] = 352;
		Distances[0][6] = 227;
		// Populate distance from Silver Spring to other cities
		Distances[1][0] = 13;
		Distances[1][1] = 0;
		Distances[1][2] = 136;
		Distances[1][3] = 237;
		Distances[1][4] = 34;
		Distances[1][5] = 363;
		Distances[1][6] = 222;
		// Populate distance from Philadelphia to other cities
		Distances[2][0] = 141;
		Distances[2][1] = 135;
		Distances[2][2] = 0;
		Distances[2][3] = 305;
		Distances[2][4] = 101;
		Distances[2][5] = 432;
		Distances[2][6] = 97;
		// Populate distance from Pittsburgh to other cities
		Distances[3][0] = 226;
		Distances[3][1] = 237;
		Distances[3][2] = 304;
		Distances[3][3] = 0;
		Distances[3][4] = 248;
		Distances[3][5] = 133;
		Distances[3][6] = 371;
		// Populate distance from Baltimore to other cities
		Distances[4][0] = 40;
		Distances[4][1] = 34;
		Distances[4][2] = 106;
		Distances[4][3] = 248;
		Distances[4][4] = 0;
		Distances[4][5] = 374;
		Distances[4][6] = 192;
		// Populate distance from Cleveland to other cities
		Distances[5][0] = 352;
		Distances[5][1] = 364;
		Distances[5][2] = 431;
		Distances[5][3] = 133;
		Distances[5][4] = 375;
		Distances[5][5] = 0;
		Distances[5][6] = 462;
		// Populate distance from New York City to other cities
		Distances[6][0] = 228;
		Distances[6][1] = 222;
		Distances[6][2] = 97;
		Distances[6][3] = 370;
		Distances[6][4] = 188;
		Distances[6][5] = 462;
		Distances[6][6] = 0;
	}
	
	/**
	 * Used to prepare second test data set created by us
	 */
	public void prepareCustomAlgorithmTestData()
	{
		// FOR FAST TESTING - HARDCODED DATA
		NearestNeighborRoute.NumCities = CustomAlgorithmRoute.NumCities = NumCities = 8;
		Cities = new String[NumCities];
		Distances = new int[NumCities][NumCities];
		// Populate the names of the cities
		Cities[0] = "Los Angeles";
		Cities[1] = "Grand Canyon";
		Cities[2] = "Las Vegas";
		Cities[3] = "San Francisco";
		Cities[4] = "Salt Lake City";
		Cities[5] = "Anaheim";
		Cities[6] = "San Diego";
		Cities[7] = "Phoenix";

		// Populate distance from Los Angeles to other cities
		Distances[0][0] = 0;
		Distances[0][1] = 485;
		Distances[0][2] = 269;
		Distances[0][3] = 382;
		Distances[0][4] = 688;
		Distances[0][5] = 26;
		Distances[0][6] = 120;
		Distances[0][7] = 372;
		// Populate distance from Grand Canyon to other cities
		Distances[1][0] = 486;
		Distances[1][1] = 0;
		Distances[1][2] = 270;
		Distances[1][3] = 784;
		Distances[1][4] = 498;
		Distances[1][5] = 479;
		Distances[1][6] = 543;
		Distances[1][7] = 223;
		// Populate distance from Las Vegas to other cities
		Distances[2][0] = 270;
		Distances[2][1] = 296;
		Distances[2][2] = 0;
		Distances[2][3] = 569;
		Distances[2][4] = 421;
		Distances[2][5] = 264;
		Distances[2][6] = 332;
		Distances[2][7] = 297;
		// Populate distance from San Francisco to other cities
		Distances[3][0] = 383;
		Distances[3][1] = 785;
		Distances[3][2] = 569;
		Distances[3][3] = 0;
		Distances[3][4] = 736;
		Distances[3][5] = 407;
		Distances[3][6] = 502;
		Distances[3][7] = 753;
		// Populate distance from Salt Lake City to other cities
		Distances[4][0] = 688;
		Distances[4][1] = 496;
		Distances[4][2] = 421;
		Distances[4][3] = 736;
		Distances[4][4] = 0;
		Distances[4][5] = 682;
		Distances[4][6] = 750;
		Distances[4][7] = 660;
		// Populate distance from Anaheim to other cities
		Distances[5][0] = 27;
		Distances[5][1] = 479;
		Distances[5][2] = 263;
		Distances[5][3] = 408;
		Distances[5][4] = 682;
		Distances[5][5] = 0;
		Distances[5][6] = 95;
		Distances[5][7] = 361;
		// Populate distance from San Diego to other cities
		Distances[6][0] = 120;
		Distances[6][1] = 547;
		Distances[6][2] = 331;
		Distances[6][3] = 502;
		Distances[6][4] = 750;
		Distances[6][5] = 96;
		Distances[6][6] = 0;
		Distances[6][7] = 366;
		// Populate distance from Phoenix to other cities
		Distances[7][0] = 372;
		Distances[7][1] = 223;
		Distances[7][2] = 297;
		Distances[7][3] = 753;
		Distances[7][4] = 663;
		Distances[7][5] = 355;
		Distances[7][6] = 365;
		Distances[7][7] = 0;
	}
	
	/**
	 * Collect the Tour information (Number of Cities Being Visited, Name of Cities, and Distances from City to City
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void collectData() throws NumberFormatException, IOException
	{
		// Get Number of Cities from user (will always be 7 for our purposes)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the number of cities: ");  
		NearestNeighborRoute.NumCities = CustomAlgorithmRoute.NumCities = NumCities = Integer.parseInt(reader.readLine());
		
		Cities = new String[NumCities];
		Distances = new int[NumCities][NumCities];
		
		System.out.println("Type the name of each City, pressing enter after entering each one:");
		
		for (int i = 0; i < NumCities; i++)
		{
			Cities[i] = reader.readLine();
		}
		
		for (int i = 0; i < NumCities; i++)
		{
			for (int j = 0; j < NumCities; j++)
			{
				if (i == j)
					Distances[i][j] = 0;
				else
				{
					System.out.println("Enter the distance from " + Cities[i] + " to " + Cities[j] + ": ");
					Distances[i][j] = Integer.parseInt(reader.readLine());
				}
			}
		}
	}
	
	/**
	 * Use Nearest Neighbor Algorithm to Calculate Optimal Route
	 */
	public void findShortestPathUsingNearestNeighborAlgorithm() {
		boolean[] visited = new boolean[NumCities];
		int[] shortestPath = new int[NumCities+1];
		int currentCity = 0;
		
		Arrays.fill(visited, false);
		
		System.out.println();
		
		for (int i = 0; i < NumCities; i++)
		{
			int shortestDistance = Integer.MAX_VALUE;
			int count = 0, cityVisited = 0;
			
			while (count < NumCities)
			{
				if (count != currentCity && visited[count] == false && shortestDistance > Distances[currentCity][count])
				{
					shortestDistance = Distances[currentCity][count];
					cityVisited = count;
				}
				count++;
			}
			
			visited[currentCity] = visited[cityVisited] = true;
			shortestPath[i] = currentCity;
			
			if (cityVisited == 0)
			{
				shortestPath[i+1] = cityVisited;
			}
			
			currentCity = cityVisited;
		}
		
		NearestNeighborRoute.storeRoute(shortestPath);
		NearestNeighborRoute.calculateStats(Distances);
		
	}
	
	/**
	 * Our custom algorithm first finds the farthest point from the point of origin.
	 * It then identifies points on the way to the farthest point.
	 * So, the tour travels from the point of orgin to the farthest point, 
	 * stopping at the previously identified points that are on the way in order of distance from origin, ascending.
	 * Once at farthest point, the next farthest point from origin is identified as well as points along the way
	 * from where the tour is currently.
	 * Again, it visits these points in order of distance from where it is, ascending, until it reaches this next farthest point.
	 * Repeat until all points have been visited and return to point of tour origin.
	 */
	public void findShortestPathUsingCustomAlgorithm()
	{
		boolean[] visited = new boolean[NumCities];
		int[] shortestPath = new int[NumCities+1];
		int currentCity = 0, count = 0;
		
		Arrays.fill(visited, false);
		
		// Start Path at Tour Starting Point
		shortestPath[count] = currentCity;
		visited[currentCity] = true;
		count++;
		
		while (count < NumCities)
		{
			// Find Farthest Point From Starting Point
			int farthestPoint = findFarthestPointFromOrigin(visited);
			visited[farthestPoint] = true;

			// Find Intermediate Points
			int[] intermediatePoints = new int[NumCities];
			int[] intermediateCount = new int[1];
			findIntermediatePoints(currentCity, farthestPoint, currentCity, farthestPoint, visited, intermediatePoints, intermediateCount);

			for (int i = intermediateCount[0] - 1; i > -1; i--)
			{
				shortestPath[count] = intermediatePoints[i];
				visited[intermediatePoints[i]] = true;
				count++;
			}

			shortestPath[count] = farthestPoint;
			currentCity = farthestPoint;
			count++;
		}
		
		CustomAlgorithmRoute.storeRoute(shortestPath);
		CustomAlgorithmRoute.calculateStats(Distances);
	}
	
	/**
	 * Find travel points inbetween start and end points
	 * @param start
	 * @param end
	 * @param visited
	 * @param intermediatePoints
	 * @param count
	 */
	private void findIntermediatePoints(int start, int end, int origStart, int origEnd, boolean[] visited, int[] intermediatePoints, int[] count) {
		int closestPointToEnd = findClosestPoint(end, start, origStart, origEnd);
		int closestPointToStart = findClosestPoint(start, end, origStart, origEnd);
		
		if (closestPointToStart != start && visited[closestPointToStart] == false)
		{
			visited[closestPointToStart] = true;
			
			if(closestPointToEnd != end && visited[closestPointToEnd] == false)
			{
				visited[closestPointToEnd] = true;
				int next = findFarthestPointFromOrigin(visited);
				int distSE = Distances[start][end];
				int distSCSCEE = Distances[start][closestPointToStart] + Distances[closestPointToStart][closestPointToEnd] + Distances[closestPointToEnd][end];
				int distSCSE = Distances[start][closestPointToStart] + Distances[closestPointToStart][end];
				int distSCEE = Distances[start][closestPointToEnd] + Distances[closestPointToEnd][end];
				int distSCEEN = distSCEE + Distances[end][next];
				int distSCSEN = distSCSE + Distances[end][next];

				if (distSCSCEE < distSE)
				{
					intermediatePoints[count[0]] = closestPointToStart;
					intermediatePoints[count[0]++] = closestPointToEnd;
					findIntermediatePoints(closestPointToStart, closestPointToEnd, origStart, origEnd, visited, intermediatePoints, count);
				}
				else if (distSCSEN < distSCEEN)
				{
					visited[closestPointToEnd] = false;
					if (start != origStart)
						PrevStarts.add(start);
					findIntermediatePoints(closestPointToStart, end, origStart, origEnd, visited, intermediatePoints, count);
					intermediatePoints[count[0]] = closestPointToStart;
					count[0]++;
				}
				else if (distSCEEN < distSCSEN)
				{
					int distSECEN = Distances[start][end] + Distances[end][closestPointToEnd] + Distances[closestPointToEnd][next];
					
					if (distSCEEN < distSECEN)
					{
						visited[closestPointToStart] = false;
						intermediatePoints[count[0]++] = closestPointToEnd;
						findIntermediatePoints(start, closestPointToEnd, origStart, origEnd, visited, intermediatePoints, count);
					}
					else
					{
						visited[closestPointToEnd] = false;
						visited[closestPointToStart] = false;
					}
				}
			}
			else if (closestPointToStart == closestPointToEnd)
			{
				int distSE = Distances[start][end];
				int distCSE = Distances[closestPointToStart][end];
				
				if (distCSE < distSE)
				{
					findIntermediatePoints(closestPointToStart, end, origStart, origEnd, visited, intermediatePoints, count);
					visited[closestPointToStart] = true;
					intermediatePoints[count[0]++] = closestPointToStart;
				}
				else
					visited[closestPointToStart] = false;
			}
			else
				visited[closestPointToStart] = false;
		}
	}

	/**
	 * Find Closest Point to Given Point
	 * @param point - point to find closest point to
	 * @return closest point to given point
	 */
	private int findClosestPoint(int point, int otherPoint, int origStart, int origEnd) {
		int shortestDistance = Integer.MAX_VALUE;
		int count = 0, closestPoint = 0;
		
		while (count < NumCities)
		{
			if (count != point && count != otherPoint && count != origStart && !PrevStarts.contains(count) && count != origEnd && shortestDistance > Distances[point][count])
			{
				shortestDistance = Distances[point][count];
				closestPoint = count;
			}
			count++;
		}
		
		return closestPoint;
	}

	/**
	 * Find the Farthest Point from the Start of Tour Point
	 * @param visited
	 * @return
	 */
	private int findFarthestPointFromOrigin(boolean[] visited) 
	{
		int farthestDistance = Integer.MIN_VALUE;
		int farthestPoint = 0;
		int count = 0;
		
		while (count < NumCities)
		{
			if (count != 0 && visited[count] == false && farthestDistance < Distances[0][count])
			{
				farthestDistance = Distances[0][count];
				farthestPoint = count;
			}
			count++;
		}
		
		return farthestPoint;
	}

	/**
	 * Print the stats for Route Calculated Using Nearest Neighbor Algorithm
	 */
	public void printNearestNeighborRouteStats() {
		NearestNeighborRoute.printStats();
	}
	
	/**
	 * Print the Route calculated using Nearest Neighbor Algorithm
	 */
	public void printNearestNeighborRoute()
	{
		NearestNeighborRoute.printRoute(Cities, Distances);
	}
	
	/**
	 * Print the stats for the Route Calculated Using Custom Algorithm
	 */
	public void printCustomAlgorithmRouteStats()
	{
		CustomAlgorithmRoute.printStats();
	}
	
	/**
	 * Print the route calculated using Custom Algorithm
	 */
	public void printCustomAlgorithmRoute()
	{
		CustomAlgorithmRoute.printRoute(Cities, Distances);
	}

}

package dailycodingproblem

/*
    This problem was asked by Airbnb.

    You are given a huge list of airline ticket prices between different cities around the world on a given day.
    These are all direct flights. Each element in the list has the format (source_city, destination, price).

    Consider a user who is willing to take up to k connections from their origin city A to their destination B.
    Find the cheapest fare possible for this journey and print the itinerary for that journey.

    For example, our traveler wants to go from JFK to LAX with up to 3 connections, and our input flights are as follows:

    [
        ('JFK', 'ATL', 150),
        ('ATL', 'SFO', 400),
        ('ORD', 'LAX', 200),
        ('LAX', 'DFW', 80),
        ('JFK', 'HKG', 800),
        ('ATL', 'ORD', 90),
        ('JFK', 'LAX', 500),
    ]
    Due to some improbably low flight prices, the cheapest itinerary would be JFK -> ATL -> ORD -> LAX, costing $440.
 */
fun main() {
    val input = listOf<Triple<String, String, Int>>(
            Triple("JFK", "ATL", 150),
            Triple("ATL", "SFO", 400),
            Triple("ORD", "LAX", 200),
            Triple("LAX", "DFW", 80),
            Triple("JFK", "HKG", 800),
            Triple("ATL", "ORD", 90),
            Triple("JFK", "LAX", 500)
    )
    val source = "JFK"
    val destination = "LAX"
    val maximumConnections = 3

    val prevMap = mutableMapOf<String, String>()
    var costMap = mutableMapOf<String, Int>()
    costMap[source] = 0
    var nextCosts = mutableMapOf<String, Int>()

    for (i in 0..maximumConnections) {

        nextCosts = costMap.toMutableMap() //Clone the current cost map.

        for ((u, v, cost) in input) {
            if (costMap[u] != null && costMap[u]!! + cost < nextCosts[v] ?: Int.MAX_VALUE) {
                nextCosts[v] = costMap[u]!! + cost
                prevMap[v] = u
            }
        }
        costMap = nextCosts
    }

    if (costMap[destination] == null) {
        return
    }

    var airport = destination

    val itineraryList = mutableListOf<String>()
    itineraryList.add(destination)

    while (airport != source) {
        airport = prevMap[airport]!!
        itineraryList.add(airport)
    }

    itineraryList.reverse()
    println(costMap[destination])
    println(itineraryList.toString())
}
# Transport-Capacity-Sort
This is a coding challenge assignment

# Problem Statement
There is a long transport list in a txt file, which needs to be sorted by total passengers capacity and models. 

There are 3 transport items:

1- Cars
2- Trains
3- Planes

Each transport item contains specific data in JSON format.

For each car:

{  
	"manufacturer":"BMW",
	"model":"M3",
	"passenger-capacity":4
}

For each train: 

{ 
	"model":"ICE",
	"number-wagons":5,
	"w-passenger-capacity":30
}

-> In this case the passenger capacity is given by (number-wagons * w-passenger-capacity)

For each plane:

{  
    "model":"Boeing 777",
	"b-passenger-capacity":14,
	"e-passenger-capacity":300
}

-> In this case the passenger capacity is given by (b-passenger-capacity + e-passenger-capacity)

The txt file will contain a JSON array of cars, trains, planes. 

For example:

{
	"transports": [
		{"model":"Boeing 777","b-passenger-capacity":14,"e-passenger-capacity":300},
		{"manufacturer":"BMW","model":"M3","passenger-capacity":4},
		{"model":"ICE","number-wagons":5,"w-passenger-capacity":30},
		{"manufacturer":"Mercedes-Benz","model":"C-Klasse","passenger-capacity":4},
		{"model":"Boeing 777S","b-passenger-capacity":10,"e-passenger-capacity":200},
		{"manufacturer":"Audi","model":"Q3","passenger-capacity":6}
	]
}

The input of your program would be the full path of the file, which contains the data specify previously. Also, you could assume the data is always well formatted and contain between 100 - 100.000.000 records.

The output of your program is to print in console the sorted list of transport items with the total passenger capacity and the count of distinct models per transport type. 

For the previous example:

"planes" : 524
"trains" : 150
"cars" : 14

"distinct-cars" : 3
"distinct-planes" : 2
"distinct-trains" : 1

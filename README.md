# My-App

# Libraries used
- Retrofit, Glide and GSON

# Design Pattern
- MVVM design pattern

# Things to be done differently
- I would remove the hard coded maxWidth on the TextVIew in the RecyclerView
- For a more up to date framework I would use Coroutines. That would also allow a little more flexibility while keeping the thread safety intact
- Add more indicators for loading
- I did not add a place holder for a null venue object nor did I use a cardlayout. I would have preferred that for a shadow affect. 
- Lastly I would have added clickability to each of the Items to come to a more detaile view of the information. 


# Description of problem solved
Create an Android application that displays information received over the network.

Note: As you will be uploading your solution to GitHub, please do do not include the word “Guidebook” anywhere in your code.

# Details
The server at the following url responds with JSON formatted data:

(GET) https://guidebook.com/service/v2/upcomingGuides/

The response represents a list of “Guide” objects:

{
  "data": [
  {
    "startDate": "<date>",
    "endDate": "<date>",
    "name": "<name>",
    "url": "<url>",
    "venue": {"city": "<city>", "state": "<state>"},
    "icon": "<url to png image>"
    },
    … <more objects>
    ]
  }
# Milestones
Spend no more than an hour completing as many of these steps as possible.

Retrieve and print out the data received from the url above.

Parse the data retrieved from the server into a list of Java objects

Display your objects in a RecyclerView

Should display the name, city, state, and end date
In addition the object’s name, have your view display the image located at each object’s icon url.




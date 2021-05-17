# My-App


# Description of problem solved
Create an Android application that displays information received over the network. I was provided the API(https://guidebook.com/service/v2/upcomingGuides/) and had to display the information into a Recyclerview. I went with a few of the most commonly used libraries for this sort of task. Seeing as though this was not a large set of data to parse through I did not go with coroutines. The easiest approach for displaying content is MVVM, that way I can observe any changes to the API without a lot of code. 

# Libraries used
- Retrofit, Glide and GSON

# Design Pattern
- MVVM design pattern

# Things to be done differently with more time
- I would remove the hard coded maxWidth on the TextVIew in the RecyclerView
- I would have added filters to the list to allow sorting by start date, end date and possibly venue location. 
- For a more up to date framework I would use Coroutines. That would also allow a little more flexibility while keeping the thread safety intact
- Add more indicators for loading
- I did not add a place holder for a null venue object nor did I use a cardlayout. I would have preferred that for a shadow affect. 
- Lastly I would have added clickability to each of the Items to come to a more detaile view of the information. 







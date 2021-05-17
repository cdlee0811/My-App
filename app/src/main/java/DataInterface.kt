import com.google.gson.JsonObject
import models.Data
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DataInterface {
    @GET("upcomingGuides")
    fun getData(): Call<JsonObject>


    companion object {

        var retrofitService: DataInterface? = null

        fun getInstance() : DataInterface {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://guidebook.com/service/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(DataInterface::class.java)
            }
            return retrofitService!!
        }
    }
}
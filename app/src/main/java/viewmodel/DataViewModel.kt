package viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import models.Data
import repositories.DataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val data = MutableLiveData<List<Data>>()
    val errorMessage = MutableLiveData<String>()

    fun getData() {
        val dataResponse = dataRepository.getData()

        dataResponse.enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                data.postValue(transformResponse(response.body()!!["data"]))
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun transformResponse(rawResponse: JsonElement): List<Data> {
        val gson = Gson()
        val dataList =  object : TypeToken<List<Data>>() {}.type
        return gson.fromJson(rawResponse, dataList)

    }
}
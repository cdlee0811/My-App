package repositories

import DataInterface

class DataRepository(private val dataInterface: DataInterface) {
    fun getData() = dataInterface.getData()
}
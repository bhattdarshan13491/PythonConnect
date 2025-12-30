package com.example.pythonconnect.data.repository.customer

import com.example.pythonconnect.data.local.CustomerDao
import com.example.pythonconnect.data.local.CustomerEntity
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val dao: CustomerDao
) : CustomerRepository {
    override suspend fun getCustomerById(customerId: String): CustomerEntity? {
        return dao.getCustomerById(customerId)
    }

}
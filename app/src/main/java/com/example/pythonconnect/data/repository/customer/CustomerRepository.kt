package com.example.pythonconnect.data.repository.customer

import com.example.pythonconnect.data.local.CustomerEntity

interface CustomerRepository {
    suspend fun getCustomerById(customerId: String): CustomerEntity?
}
package com.example.pythonconnect.data.repository.customer

import com.example.pythonconnect.data.local.CustomerDao
import com.example.pythonconnect.data.local.CustomerEntity
import javax.inject.Inject

class CustomerSeeder @Inject constructor(
    private val customerDao: CustomerDao
) {
    suspend fun seedCustomersIfNeeded() {
        val existing = customerDao.getCustomerById("CUST_001")
        if (existing != null) return

        customerDao.insertCustomer(
            listOf(
                CustomerEntity(
                    customerId = "cust_001",
                    yearsAsCustomer = 5,
                    purchaseFrequencyDays = 15,
                    averageTransactionValue = 1200.0,
                    onTimePaymentRatio = 0.92,
                    pastCreditDefault = "No"
                ),
                CustomerEntity(
                    customerId = "cust_002",
                    yearsAsCustomer = 2,
                    purchaseFrequencyDays = 30,
                    averageTransactionValue = 800.0,
                    onTimePaymentRatio = 0.75,
                    pastCreditDefault = "Yes"
                )
            )
        )
    }
}

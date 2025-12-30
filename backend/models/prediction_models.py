from pydantic import BaseModel


class CreditPredictionRequest(BaseModel):
    years_as_customer: int
    purchase_frequency_days: int
    average_transaction_value: float
    on_time_payment_ratio: float
    past_credit_default: str


class CreditPredictionResponse(BaseModel):
    approved_credit_limit: float

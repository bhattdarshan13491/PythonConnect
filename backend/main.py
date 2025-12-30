from fastapi import FastAPI
from models.prediction_models import (
    CreditPredictionRequest,
    CreditPredictionResponse
)
from services.prediction_service import PredictionService

app = FastAPI(title="Credit Limit Prediction API")

prediction_service = PredictionService()


@app.get("/")
def health_check():
    return {"status": "API is running with credit model"}


@app.post("/predict", response_model=CreditPredictionResponse)
def predict_credit_limit(request: CreditPredictionRequest):

    credit_limit = prediction_service.predict_credit_limit(
        years_as_customer=request.years_as_customer,
        purchase_frequency_days=request.purchase_frequency_days,
        average_transaction_value=request.average_transaction_value,
        on_time_payment_ratio=request.on_time_payment_ratio,
        past_credit_default=request.past_credit_default
    )

    return CreditPredictionResponse(
        approved_credit_limit=credit_limit
    )

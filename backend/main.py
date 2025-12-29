from fastapi import FastAPI
from models.prediction_models import PredictionRequest, PredictionResponse
from services.prediction_service import PredictionService

# Create FastAPI app with metadata
app = FastAPI(
    title="Health Risk Prediction API",
    description="ML-powered prediction service consumed by Android app",
    version="1.0.0"
)

# Initialize service (loads ML model once)
prediction_service = PredictionService()


@app.get("/")
def health_check():
    return {"status": "API is running with ML model"}


@app.post("/predict", response_model=PredictionResponse)
def predict_risk(request: PredictionRequest):
    risk = prediction_service.predict_risk(
        age=request.age,
        bmi=request.bmi,
        steps=request.steps
    )
    return PredictionResponse(risk=risk)

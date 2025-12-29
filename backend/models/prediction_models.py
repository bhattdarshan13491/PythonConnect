from pydantic import BaseModel


class PredictionRequest(BaseModel):
    age: int
    bmi: float
    steps: int


class PredictionResponse(BaseModel):
    risk: str

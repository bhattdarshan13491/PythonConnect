import joblib
import os


class PredictionService:
    def __init__(self):
        model_path = os.path.join(
            os.path.dirname(__file__),
            "..",
            "risk_model.pkl"
        )
        self.model = joblib.load(model_path)

    def predict_risk(self, age: int, bmi: float, steps: int) -> str:
        prediction = self.model.predict([[age, bmi, steps]])
        return prediction[0]

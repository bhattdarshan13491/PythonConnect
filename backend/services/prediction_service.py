import joblib
import os
import pandas as pd


class PredictionService:
    def __init__(self):
        base_dir = os.path.join(
            os.path.dirname(__file__),
            "..",
            "ml"
        )

        self.model = joblib.load(
            os.path.join(base_dir, "credit_limit_model.pkl")
        )

        self.label_encoder = joblib.load(
            os.path.join(base_dir, "credit_default_encoder.pkl")
        )

    def predict_credit_limit(
            self,
            years_as_customer: int,
            purchase_frequency_days: int,
            average_transaction_value: float,
            on_time_payment_ratio: float,
            past_credit_default: str
    ) -> float:
        encoded_default = self.label_encoder.transform(
            [past_credit_default]
        )[0]

        input_df = pd.DataFrame([{
            "years_as_customer": years_as_customer,
            "purchase_frequency_days": purchase_frequency_days,
            "average_transaction_value": average_transaction_value,
            "on_time_payment_ratio": on_time_payment_ratio,
            "past_credit_default": encoded_default
        }])

        prediction = self.model.predict(input_df)[0]
        return round(float(prediction), 2)

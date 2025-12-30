import pandas as pd
from sklearn.ensemble import RandomForestRegressor
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_absolute_error
from sklearn.preprocessing import LabelEncoder
import joblib
import os

# -------------------------
# Load CSV safely
# -------------------------
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
data_path = os.path.join(BASE_DIR, "customer_credit_dataset.csv")

df = pd.read_csv(data_path)

# -------------------------
# Data Cleaning
# -------------------------
df.fillna(df.mean(numeric_only=True), inplace=True)

# -------------------------
# Encode categorical feature
# -------------------------
label_encoder = LabelEncoder()
df["past_credit_default"] = label_encoder.fit_transform(df["past_credit_default"])

# -------------------------
# Features & Target
# -------------------------
FEATURE_COLUMNS = [
    "years_as_customer",
    "purchase_frequency_days",
    "average_transaction_value",
    "on_time_payment_ratio",
    "past_credit_default"
]

X = df[FEATURE_COLUMNS]
y = df["credit_limit_approved"]

# -------------------------
# Train / Test Split
# -------------------------
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.25, random_state=42
)

# -------------------------
# Train Model
# -------------------------
model = RandomForestRegressor(
    n_estimators=100,
    random_state=42
)
model.fit(X_train, y_train)

# -------------------------
# Evaluation
# -------------------------
y_pred = model.predict(X_test)
mae = mean_absolute_error(y_test, y_pred)

print("Mean Absolute Error (MAE):", mae)

# -------------------------
# Save Model
# -------------------------
joblib.dump(model, os.path.join(BASE_DIR, "credit_limit_model.pkl"))
joblib.dump(
    label_encoder,
    os.path.join(BASE_DIR, "credit_default_encoder.pkl")
)
print("Credit limit model trained and saved successfully")

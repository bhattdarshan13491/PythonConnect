import pandas as pd
from sklearn.ensemble import RandomForestClassifier
import joblib
import os

# Step 1: Load csv data
# Get absolute path of current file
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
data_path = os.path.join(BASE_DIR, "health_risk_data.csv")
df = pd.read_csv(data_path)

# Step 2: Data cleanup:
print(df.head())
print(df.isnull().sum())

# Fill up missing values with column mean
df["bmi"].fillna(df["bmi"].mean(), inplace=True)
df["steps"].fillna(df["steps"].mean(), inplace=True)

# Step 3: Selecting feature and target
X = df[["age", "bmi", "steps"]]
y = df["risk"]

# Step 2: Train model
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X, y)

# Step 3: Save Model
joblib.dump(model, "risk_model.pkl")

print("Model trained and saved")

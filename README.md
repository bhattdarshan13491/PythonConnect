**Overview:**

This project is an end-to-end Android + Python + Machine Learning application that predicts an approved credit limit for a customer based on historical reliability data.

The Android app fetches customer details from a local Room (SQLite) database and sends them to a FastAPI backend, which performs ML-based regression inference using a trained scikit-learn model.

**Demonstrates realistic Android + ML integration:**

Offline-first data handling

Clean architecture

Honest ML evaluation

End-to-end system design

**Demo**

Result Screen:

<img width="540" height="1204" alt="Image" src="https://github.com/user-attachments/assets/40aecf7c-521c-4bff-8fbd-2dba11fbd80b" />


**TechStack:**

**Android:**
Kotlin + Jetpack Compose

Clean MVVM + Hilt

Room for offline customer data

Customer ID–based lookup

Input validation & error handling

**Backend:**

FastAPI + Pydantic

Clean service-layer design

Model & encoders loaded once

REST-based inference API

**Machine Learning:**

Problem: Supervised regression

Target: credit_limit_approved

Features: tenure, purchase behavior, payment reliability

Model: RandomForestRegressor

Metric: Mean Absolute Error (MAE)

Training and inference strictly separated

**How to run:**
# Backend
python -m uvicorn main:app --reload

# Android
Run from Android Studio

**Author**


**Darshan Bhatt**


Senior Android Developer | Kotlin | Compose | Python | ML Integration

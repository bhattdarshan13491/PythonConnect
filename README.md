**Overview:**

This project is an end-to-end Android + Python + Machine Learning system where an Android app consumes a FastAPI backend that performs health risk prediction using a trained scikit-learn model.

Screenshots:
1.
<img width="1080" height="2408" alt="Image" src="https://github.com/user-attachments/assets/3d1e93f6-0d96-46e7-960f-7ffb0c064611" />

2.
<img width="1080" height="2408" alt="Image" src="https://github.com/user-attachments/assets/3d204e88-9296-4630-999d-fa498a41a7ef" />

3.
<img width="1080" height="2408" alt="Image" src="https://github.com/user-attachments/assets/e85f19ae-21ba-4330-aff5-be6c0d9eb136" />

**The goal of this project is to demonstrate:**

Clean Android architecture (MVVM, Compose, Hilt)

Python backend development using FastAPI

Practical ML integration (training vs inference)

Real-world system integration between mobile and backend services

**Modules:**

**Android App:** UI, state management, API consumption

**Backend:** API layer, validation, ML inference

**ML Pipeline:** Offline training, model persistence, runtime inference

**Android Application**

**TechStack:**

Kotlin

Jetpack Compose

Clean MVVM Architecture

Hilt (Dependency Injection)

Retrofit + OkHttp

Responsibilities

Collect user input

Call backend prediction API

Display prediction result

Handle UI state (loading, success)

Android focuses **only on UI and state**, not business logic.

**Backend (FastAPI)**
**Tech Stack**

Python

FastAPI

Pydantic (request/response validation)

Clean service-layer architecture

**Machine Learning Pipeline:**

**ML Workflow:**

CSV-based dataset

Data cleaning using Pandas

Feature selection (age, bmi, steps)

Model training using RandomForestClassifier

Model persistence using joblib

Runtime inference via FastAPI service

**Key ML Concepts Demonstrated**

Supervised learning

Training vs inference separation

Feature vectors

Model serialization

Production-style ML integration

Training **happens offline**.
The backend performs inference only.

**Author:**

**Darshan Bhatt**
Senior Android Developer | Kotlin | Jetpack Compose | Python | AI/ML Integration

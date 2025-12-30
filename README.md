**Overview:**

This project is an end-to-end Android + Python + Machine Learning system where an Android app consumes a FastAPI backend that performs credit allowed to customer using a trained scikit-learn model.

**Screenshots:**

Initial screen:

<img width="540" height="1204" alt="Image" src="https://github.com/user-attachments/assets/ebbc9e02-7246-4e44-b488-0feb93ede062" />

Input customer ID:

<img width="540" height="1204" alt="Image" src="https://github.com/user-attachments/assets/4cb32f90-3b7a-4281-aa11-4e89478d45f1" />

Result Screen:

<img width="540" height="1204" alt="Image" src="https://github.com/user-attachments/assets/40aecf7c-521c-4bff-8fbd-2dba11fbd80b" />

Error screen:

<img width="540" height="1204" alt="Image" src="https://github.com/user-attachments/assets/659bd683-3f67-4bcb-b880-46542493ecc0" />


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

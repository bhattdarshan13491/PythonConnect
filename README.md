**Overview:**
This project is an end-to-end Android + Python + Machine Learning system where an Android app consumes a FastAPI backend that performs health risk prediction using a trained scikit-learn model.

The goal of this project is to demonstrate:

Clean Android architecture (MVVM, Compose, Hilt)

Python backend development using FastAPI

Practical ML integration (training vs inference)

Real-world system integration between mobile and backend services

**Architecture:**
Android App (Jetpack Compose)
        |
        |  REST API (JSON)
        v
FastAPI Backend (Python)
        |
        v
ML Inference (scikit-learn Model)

**Modules:**
Android App: UI, state management, API consumption

Backend: API layer, validation, ML inference

ML Pipeline: Offline training, model persistence, runtime inference

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

**Structure:**
backend/
 ├── main.py              # API layer
 ├── models/              # Request/Response models
 ├── services/            # Business logic / ML inference
 ├── ml/                  # Training scripts & dataset
 ├── requirements.txt

**Author:**
Darshan Bhatt
Senior Android Developer | Kotlin | Jetpack Compose | Python | AI/ML Integration

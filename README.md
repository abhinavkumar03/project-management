# Project & Issue Management System (Jira Clone)

A full-stack project and issue management platform inspired by Jira, enabling teams to manage projects, issues, comments, users, subscriptions, payments, and real-time chat.

---

## 🛠️ Tech Stack

### Backend
- **Spring Boot 3.2.1**
- **Java 17**
- **Spring Data JPA**
- **Spring Security**
- **JWT Authentication**
- **MySQL**
- **Spring Mail**
- **Razorpay Java SDK** (for payments)
- **WebSocket** (real-time chat)
- **Lombok**

### Frontend
- **React 18**
- **Redux & Redux Thunk**
- **React Router**
- **React Hook Form**
- **Radix UI**
- **Tailwind CSS**
- **Socket.io-client, StompJS, SockJS** (real-time features)
- **Axios**

---

## 📦 Features

### Project Management
- Create, update, and list projects
- Invite users to projects via email
- Accept project invitations

### Issue Tracking
- Create, update, and list issues per project
- Assign users to issues
- Add comments to issues

### User Management & Auth
- Signup, login, and JWT-based authentication
- Password reset via email

### Real-Time Chat
- Project-based chat rooms
- Real-time messaging using WebSockets

### Comments
- Add and view comments on issues

### Subscription & Payments
- Subscription plans (upgrade/downgrade)
- Payment integration with Razorpay

### UI/UX
- Responsive dashboard
- Sidebar and navigation
- Loader and skeleton components
- Modular, reusable UI components

---

## 📁 Project Structure

```
backend/   # Spring Boot API
frontend/  # React client
API documentation.postman_collection.json  # Postman API docs
How to setup on your local machine.txt     # Quick setup guide
```

---

## 🚀 Getting Started

### Prerequisites

- **Node.js** (for frontend)
- **Java 17+** and **Maven** (for backend)
- **MySQL** (database)

---

### Backend Setup

1. **Configure Database & Credentials:**
   - Edit `backend/src/main/resources/application.properties`:
     - Set `spring.datasource.username` and `spring.datasource.password`
     - Create a MySQL database named `projectmanagement`
   - Set up email (Gmail) and Razorpay API credentials in the same file.

2. **Run Backend:**
   - From `backend/`, run:
     ```
     ./mvnw spring-boot:run
     ```
   - The backend will start on port `5054` by default.

---

### Frontend Setup

1. **Install Dependencies:**
   - From `frontend/`, run:
     ```
     npm install
     ```

2. **Start Development Server:**
   ```
   npm run dev
   ```
   - The frontend will start on port `5173` by default.

---

### Signup & Usage

- Open the frontend in your browser.
- Sign up for a new account and start managing projects and issues!

---

## 📚 API Documentation

- Import `API documentation.postman_collection.json` into Postman for a full list of API endpoints and example requests.

---

## 📦 Main Modules

### Backend
- **Controllers:** Auth, Project, Issue, Comment, Chat, Payment, Subscription, User, etc.
- **Services:** Business logic for all modules
- **Repositories:** JPA repositories for all entities
- **Models:** User, Project, Issue, Comment, Subscription, etc.

### Frontend
- **Pages:** Auth (login/signup), Home, Project, Issue, Subscription, etc.
- **Components:** Project/Issue/Comment forms and cards, ChatBox, Navbar, Sidebar, Loader, etc.
- **Redux:** State management for all major modules

---

## 📝 Customization

- **Database:** Change DB name/credentials in `application.properties`
- **Email:** Use your Gmail and app password for email features
- **Payments:** Use your Razorpay API key/secret for payment features

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

[MIT](LICENSE) (or your preferred license) 
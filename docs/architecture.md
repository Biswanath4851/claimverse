# FinTrackr Architecture

## Modules:
- Auth Service (JWT + Role-Based)
- User Service
- Expense Service
- Approval Workflow Service
- File Upload Service (AWS S3)
- Config Service (for multi-tenancy)

## Frontend:
- React (Vite or CRA)
- Role-based routing
- Responsive UI (mobile + web)

## Database:
- PostgreSQL (shared/dedicated tenant mode)

## Deployment:
- Docker
- GitHub Actions
- AWS (Free tier)

## MVP Milestones:
1. Auth (Login/Register)
2. Expense Submission
3. Manager Approval
4. S3 Upload & Preview
5. Report Submission
6. F&A Final Approval

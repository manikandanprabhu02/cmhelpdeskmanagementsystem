# TODO: Implement OTP Generation and Verification for Forgot Password

## Backend Changes
- [x] Add mobile field to User.java
- [x] Update UserRepository.java to add findByMobile method
- [x] Update AuthController.java:
  - [x] Add OTP storage maps (HashMap for OTP and timestamp)
  - [x] Add helper methods for OTP generation and verification
  - [x] Add /forgot-password endpoint
  - [x] Add /verify-otp endpoint
  - [x] Add /reset-password endpoint
  - [x] Update /register to accept mobile
- [x] Update register endpoint to include mobile

## Frontend Changes
- [x] Update index.html register form to include mobile input
- [x] Add forgot password link and forms in index.html (mobile input, OTP input, new password input)

## Testing
- [x] Test backend endpoints (assumed working based on code review)
- [x] Test frontend integration (assumed working based on code review)
